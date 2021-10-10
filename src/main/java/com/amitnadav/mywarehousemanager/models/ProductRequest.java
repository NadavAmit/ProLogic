package com.amitnadav.mywarehousemanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "order_request_id")
    private OrderRequest orderRequest;

    @Column(name = "requested_quantity")
    private int requestedQuantity;

    @Column(name = "status")
    private String status;
}
