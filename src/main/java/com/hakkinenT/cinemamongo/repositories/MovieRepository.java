package com.hakkinenT.cinemamongo.repositories;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hakkinenT.cinemamongo.models.entities.movies.Movie;

public interface MovieRepository extends MongoRepository<Movie, String>{
    @Aggregation(pipeline = {
        "{$match: {_id: ?0}}",
        "{$lookup: {from: \"sessions\",localField: \"_id\",foreignField: \"movie\",as: \"sessions\",pipeline: [{$match: {sessionClosed: false}}]}}"
    })
    Movie searchMovieById(String id);
}
