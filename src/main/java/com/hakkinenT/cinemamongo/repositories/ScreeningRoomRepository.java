package com.hakkinenT.cinemamongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hakkinenT.cinemamongo.models.entities.rooms.ScreeningRoom;

public interface ScreeningRoomRepository extends MongoRepository<ScreeningRoom, Integer>{

}
