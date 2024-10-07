package com.hakkinenT.cinemamongo.exceptions.customs;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg){
        super(msg);
    }
}
