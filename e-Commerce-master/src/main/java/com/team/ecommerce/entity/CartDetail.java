package com.team.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(columnDefinition = "INT(10) DEFAULT 1")
    private Integer quantity;


    private Long totalPrice;
}
