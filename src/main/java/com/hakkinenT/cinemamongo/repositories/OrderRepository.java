package com.hakkinenT.cinemamongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hakkinenT.cinemamongo.models.entities.orders.Order;

public interface OrderRepository extends MongoRepository<Order, String>{
    @Query(value="{ '_id' : ?0 }", fields="{ '_id' : 0, 'tickets' : 1}")
    Order searchTicketsByOrderId(String orderID);
}
