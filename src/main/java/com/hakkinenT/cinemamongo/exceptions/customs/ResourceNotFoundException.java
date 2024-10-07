package com.hakkinenT.cinemamongo.exceptions.customs;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
