package com.amitnadav.mywarehousemanager.repositories;

import com.amitnadav.mywarehousemanager.models.OrderRequest;
import org.springframework.data.repository.CrudRepository;

public interface OrderRequestRepository extends CrudRepository<OrderRequest,Integer> {
}
