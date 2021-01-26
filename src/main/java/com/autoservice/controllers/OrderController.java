package com.autoservice.controllers;

import com.autoservice.models.Check;
import com.autoservice.models.OrderedService;
import com.autoservice.models.Service;
import com.autoservice.services.ClosedCheck;
import com.autoservice.services.OpenCheck;
import com.autoservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

        @Autowired
        private OrderService orderService;


        @PostMapping("/new")
        public OpenCheck openOrder() {
            return orderService.openOrder();
        }

        @PostMapping("/services")
        public OrderedService addServiceToOrder(@RequestBody Service service) {
            return orderService.addServiceToOrder(service);
        }

        @DeleteMapping("/services/{id}")
        public void deleteServiceFromOrder(@PathVariable Integer id) {
            orderService.deleteServiceFromOrder(id);
        }

        @GetMapping
        public OpenCheck getOpenCheck() {
            return orderService.getOpenCheck();
        }

        @PutMapping
        public Check closeOrder() {
            return orderService.closeOrder();
        }

        @GetMapping("/orders")
        public List<ClosedCheck> getAllChecks() {
            return orderService.getCostByCategory();
        }


}
