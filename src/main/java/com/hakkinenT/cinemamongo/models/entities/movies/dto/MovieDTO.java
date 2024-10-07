package com.hakkinenT.cinemamongo.models.entities.movies.dto;

import com.hakkinenT.cinemamongo.models.entities.movies.Movie;
import com.hakkinenT.cinemamongo.models.entities.movies.embedded.Actor;
import com.hakkinenT.cinemamongo.models.entities.movies.embedded.Gender;
import com.hakkinenT.cinemamongo.models.entities.sessions.Session;
import com.hakkinenT.cinemamongo.models.entities.sessions.dto.SessionMinDTO;

import java.util.*;

public class MovieDTO {
    private String id;
    private String title;
    private String duration;
    private String imageUrl;
    private String synopsis;
    private String ageRating;
    private List<Gender> genders = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();
    private List<SessionMinDTO> sessions = new ArrayList<>();
    
    public MovieDTO() {
    }

    public MovieDTO(String id, String title, String duration, String imageUrl, String synopsis, String ageRating,
            List<Gender> genders, List<Actor> actors) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
        this.ageRating = ageRating;
        this.genders = genders;
        this.actors = actors;
    }

    public MovieDTO(Movie entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.duration = entity.getDuration();
        this.imageUrl = entity.getImageUrl();
        this.synopsis = entity.getSynopsis();
        this.ageRating = entity.getAgeRating();
        this.genders = entity.getGenders();
        this.actors = entity.getActors();

    }

    public MovieDTO(Movie entity, List<Session> sessions) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.duration = entity.getDuration();
        this.imageUrl = entity.getImageUrl();
        this.synopsis = entity.getSynopsis();
        this.ageRating = entity.getAgeRating();
        this.genders = entity.getGenders();
        this.actors = entity.getActors();

        for(Session s : sessions){
            this.sessions.add(new SessionMinDTO(s));
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<SessionMinDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionMinDTO> sessions) {
        this.sessions = sessions;
    }

    
}
