package com.autoservice.services;

import com.autoservice.models.Check;
import com.autoservice.models.CostByCategory;
import com.autoservice.models.OrderedService;
import com.autoservice.repositories.CheckRepository;
import com.autoservice.repositories.OrderedServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderedServicesRepository orderedServicesRepository;

    @Autowired
    private final CheckRepository checkRepository;


    public OrderService(OrderedServicesRepository orderedServicesRepository, CheckRepository checkRepository) {
        this.orderedServicesRepository = orderedServicesRepository;
        this.checkRepository = checkRepository;
    }

    public OpenCheck openOrder() {
        Check check = checkRepository.save(new Check(BigDecimal.valueOf(0), false));
        List<OrderedService> services = new ArrayList<>();
        return new OpenCheck(services, check);
    }

    public OrderedService addServiceToOrder(com.autoservice.models.Service service) {
        Check check = checkRepository.searchOpenCheck().get(0);
        return orderedServicesRepository.save(new OrderedService(service.getName(), service.getCategory(), service.getCost(), service.getDescription(), false, check));
    }

    public Check closeOrder() {
        Check check = checkRepository.searchOpenCheck().get(0);
        List<OrderedService> services = orderedServicesRepository.searchOrderedServices(check.getCheck_id());
        BigDecimal totalCost = BigDecimal.valueOf(0);
        for (OrderedService service : services) {
            totalCost = totalCost.add(service.getCost());
        }
        check.setTotalCost(totalCost);
        check.setComplete(true);
        checkRepository.save(check);
        return check;
    }

    public OpenCheck getOpenCheck() {
        Check check;
        if (checkRepository.searchOpenCheck().size() != 0) {
            check = checkRepository.searchOpenCheck().get(0);
        } else {
            check = checkRepository.save(new Check(BigDecimal.valueOf(0), false));
        }
        List<OrderedService> services = orderedServicesRepository.searchOrderedServices(check.getCheck_id());
        return new OpenCheck(services, check);
    }

    public void deleteServiceFromOrder(int id) {
        Check check = checkRepository.searchOpenCheck().get(0);
        List<OrderedService> orderedServices = orderedServicesRepository.searchOrderedServices(check.getCheck_id());
        for (OrderedService orderedService : orderedServices) {
            if (orderedService.getService_id().equals(id)) {
                orderedServicesRepository.deleteById(id);
            }
        }
    }

    public List<ClosedCheck> getCostByCategory() {
        List<ClosedCheck> closedChecks = new ArrayList<>();
        List<Check> checks = checkRepository.searchCloseChecks();
        for(Check check : checks){
            List<OrderedService> orderedServices = orderedServicesRepository.searchOrderedServices(check.getCheck_id());
            List<String> categories = new ArrayList<>();
            for (OrderedService service : orderedServices) {
                categories.add(service.getCategory());
            }
            HashSet<String> uniqueCategories = new HashSet<>(categories);
            List<CostByCategory> costByCategories = new ArrayList<>();

            for (String category : uniqueCategories) {
                BigDecimal costByCategory = BigDecimal.valueOf(0);
                for (OrderedService service : orderedServices) {
                    if(service.getCategory().equals(category)){
                        costByCategory = costByCategory.add(service.getCost());
                    }
                }
                costByCategories.add(new CostByCategory(costByCategory, category));
                costByCategory = BigDecimal.valueOf(0);
            }
            closedChecks.add(new ClosedCheck(costByCategories, check));
        }
        return closedChecks;
    }

    public List<Check> getAllChecks() {
        return checkRepository.searchCloseChecks();
    }
}
