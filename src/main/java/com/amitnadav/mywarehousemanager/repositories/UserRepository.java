package com.amitnadav.mywarehousemanager.repositories;

import com.amitnadav.mywarehousemanager.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
