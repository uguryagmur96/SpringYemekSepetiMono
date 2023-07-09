package com.yemeksepeti.services;

import com.yemeksepeti.dto.request.OrderFindAllOrderRequestDto;
import com.yemeksepeti.dto.request.OrderGetOrderRequestDto;
import com.yemeksepeti.dto.response.OrderGetOrderResponseDto;
import com.yemeksepeti.exception.ErrorType;
import com.yemeksepeti.exception.YemekSepetiException;
import com.yemeksepeti.mapper.IOrderMapper;
import com.yemeksepeti.repository.ICustomerRepository;
import com.yemeksepeti.repository.IOrderRepository;
import com.yemeksepeti.repository.IRestaurantRepository;
import com.yemeksepeti.repository.entity.Customer;
import com.yemeksepeti.repository.entity.Order;
import com.yemeksepeti.repository.entity.Restaurant;
import com.yemeksepeti.util.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends ServiceManager<Order,Long> {
    private final IOrderRepository orderRepository;
    private final ICustomerRepository customerRepository;
    private final IRestaurantRepository restaurantRepository;

    public OrderService(IOrderRepository orderRepository,ICustomerRepository customerRepository,IRestaurantRepository restaurantRepository) {
        super(orderRepository);
        this.orderRepository=orderRepository;
        this.customerRepository=customerRepository;
        this.restaurantRepository=restaurantRepository;
    }

    public OrderGetOrderResponseDto saveOrder(OrderGetOrderRequestDto dto){
        Optional<Customer> optCus=customerRepository.findById(dto.getCustomerid());
        Optional<Restaurant> optRes=restaurantRepository.findById(dto.getRestaurantid());
        if (optCus.isEmpty()){
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }
        if (optRes.isEmpty()){
            throw new YemekSepetiException(ErrorType.RESTAURANT_NOT_FOUND);
        }
        Order order= IOrderMapper.INSTANCE.orderFromDto(dto);
        orderRepository.save(order);
        OrderGetOrderResponseDto resDto=IOrderMapper.INSTANCE.dtoFromOrder(order);
        return resDto;
    }

    public Optional<Order> findAllOrders(OrderFindAllOrderRequestDto dto) {
        Optional<Customer> optCus=customerRepository.findOptionalByEmail(dto.getEmail());
        if(optCus.isEmpty()){
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }
        Long id=customerRepository.findOptionalByEmail(dto.getEmail()).get().getId();
        Optional<Order> orderList=orderRepository.findAllByCustomerid(id);
        return orderList;
    }
}
