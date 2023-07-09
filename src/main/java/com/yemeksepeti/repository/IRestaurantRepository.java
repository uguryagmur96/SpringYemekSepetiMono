package com.yemeksepeti.repository;

import com.yemeksepeti.repository.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Long> {
}
