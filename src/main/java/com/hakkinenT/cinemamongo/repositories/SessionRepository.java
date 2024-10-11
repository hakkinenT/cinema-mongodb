package com.hakkinenT.cinemamongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hakkinenT.cinemamongo.models.entities.sessions.Session;
import com.hakkinenT.cinemamongo.models.entities.sessions.compositeKey.SessionPK;

public interface SessionRepository extends MongoRepository<Session, SessionPK>{

}
