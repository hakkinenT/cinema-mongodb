package com.hakkinenT.cinemamongo.models.entities.movies.embedded;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    private String name;

    private List<Acts> acts = new ArrayList<>();

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Acts> getActs() {
        return acts;
    }

    public void addActs(Acts acts){
        this.acts.add(acts);
    }
}