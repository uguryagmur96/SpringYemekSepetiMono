package com.yemeksepeti.controller;

import com.yemeksepeti.dto.request.OrderFindAllOrderRequestDto;
import com.yemeksepeti.dto.request.OrderGetOrderRequestDto;
import com.yemeksepeti.dto.response.OrderGetOrderResponseDto;
import com.yemeksepeti.repository.entity.Order;
import com.yemeksepeti.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.yemeksepeti.constants.RestApiList.*;

@RestController
@RequestMapping(ORDER)
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    public ResponseEntity<OrderGetOrderResponseDto> giveAnOrder(OrderGetOrderRequestDto dto){
     return ResponseEntity.ok(orderService.saveOrder(dto));
    }
    public ResponseEntity<Optional<Order>> findAllOrder(OrderFindAllOrderRequestDto dto){
        return ResponseEntity.ok(orderService.findAllOrders(dto));
    }
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
}
