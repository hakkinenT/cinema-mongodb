package com.hakkinenT.cinemamongo.models.entities.movies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hakkinenT.cinemamongo.models.entities.movies.embedded.Actor;
import com.hakkinenT.cinemamongo.models.entities.movies.embedded.Gender;
import com.hakkinenT.cinemamongo.models.entities.sessions.Session;

@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    private String title;
    private String duration;
    private String imageUrl;
    private String synopsis;
    private String ageRating;
    private List<Gender> genders = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();

    private List<Session> sessions = new ArrayList<>();
    
    public Movie() {
    }

    public Movie(String id, String title, String duration, String imageUrl, String synopsis, String ageRating) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
        this.ageRating = ageRating;
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

    public List<Actor> getActors() {
        return actors;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}