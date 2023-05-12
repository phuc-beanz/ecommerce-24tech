package com.team.ecommerce.repository;

import com.team.ecommerce.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {

}
