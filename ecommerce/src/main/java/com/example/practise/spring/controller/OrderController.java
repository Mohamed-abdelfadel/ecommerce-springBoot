package com.example.practise.spring.controller;

import com.example.practise.spring.dto.OrderDto;
import com.example.practise.spring.entity.Item;
import com.example.practise.spring.entity.Order;
import com.example.practise.spring.entity.OrderStatus;
import com.example.practise.spring.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderServices;

    @GetMapping
    public List<OrderDto> get(){
        return orderServices.get();
    }
    @PostMapping
    public Order add(@RequestBody Order order){
        return orderServices.add(order);
    }

    @GetMapping("/customer/{id}")
    public List<OrderDto> findByCustomerId(@PathVariable Long id){
        return orderServices.findByCustomerId(id);
    }
    @GetMapping("/status/{id}")
    public List<OrderDto> findByStatusId(@PathVariable Long id){
        return orderServices.findByStatusId(id);
    }

    @GetMapping("/{id}")
    public List<Item> getItems(@PathVariable Long id) {
        return orderServices.getItems(id);
    }


    @PostMapping("/{orderId}/product")
    public void addItem(@PathVariable Long orderId,
                        @RequestParam Long productId,
                        @RequestParam int amount) {
        orderServices.addItem(orderId, productId, amount);
    }
    @PutMapping("/{id}/status")
    public Order status(@PathVariable Long id , @RequestBody OrderStatus status){
        return orderServices.status(id , status);
    }
    @PutMapping("/{id}")
    public Order update(@PathVariable Long id ,@RequestBody Order order){
        return orderServices.update(id,order);
    }
    @PutMapping("/{id}/shipped")
    public Order shipped(@PathVariable Long id){
        return orderServices.shipped(id);
    }
}
