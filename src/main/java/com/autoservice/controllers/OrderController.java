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

@RestController
@RequestMapping("/order")
public class OrderController {

        @Autowired
        private OrderService orderService;

        @CrossOrigin
        @PostMapping("/new")
        public OpenCheck openOrder() {
            return orderService.openOrder();
        }

        @CrossOrigin
        @PostMapping("/services")
        public OrderedService addServiceToOrder(@RequestBody Service service) {
            return orderService.addServiceToOrder(service);
        }

        @CrossOrigin
        @DeleteMapping("/services/{id}")
        public void deleteServiceFromOrder(@PathVariable Integer id) {
            orderService.deleteServiceFromOrder(id);
        }

        @CrossOrigin
        @GetMapping
        public OpenCheck getOpenCheck() {
            return orderService.getOpenCheck();
        }

        @CrossOrigin
        @PutMapping
        public Check closeOrder() {
            return orderService.closeOrder();
        }

        @CrossOrigin
        @GetMapping("/orders")
        public List<ClosedCheck> getAllChecks() {
            return orderService.getCostByCategory();
        }


}
