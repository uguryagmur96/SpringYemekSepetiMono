package com.yemeksepeti.repository;

import com.yemeksepeti.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findAllByCustomerid(Long id);
}
