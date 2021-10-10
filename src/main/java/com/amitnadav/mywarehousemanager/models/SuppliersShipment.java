package com.amitnadav.mywarehousemanager.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
/*
* Suppliers Shipment represents a specific shipment of a certain supplier.
* The shipment will contain a list of different items that being shipped into the warehouse.* i.e: A supplier shipmnet from Tnuva that will conatin : milk , cheese , yogurt
* */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int shipmentId;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @JsonBackReference
    private Supplier supplier;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "suppliersShipment",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<IncomingProduct> incomingProductsList;

}
