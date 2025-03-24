package com.example.ha_web_deployment_2.models;

public interface GenericEntity<T> {

    // update current instance with provided data
    void update(T source);

    Long getId();

    // based on current data create new instance with new id
    T createNewInstance();

}

