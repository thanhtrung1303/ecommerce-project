package com.example.ecommerce.controller.admin;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/admin/orders")
    public String getOrderManagePage(Model model) {

        model.addAttribute("orders", orderRepository.findAll());

        return "admin/order/list";
    }

    @GetMapping("/admin/orders/{id}")
    public String getOrderDetailPage(Model model, @PathVariable long id) {
        Order order = orderService.getOrderById(id);

        model.addAttribute("order", order);

        return "admin/order/detail";
    }

    @PutMapping("/api/admin/orders/{id}/update-status")
    public ResponseEntity<?> updateStatusOrder(@Valid @RequestBody Order order, @PathVariable long id) {

        orderService.updateStatusOrder(order, id);

        return ResponseEntity.ok("Cập nhật thành công");
    }
}
