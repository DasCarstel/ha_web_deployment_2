package com.example.ha_web_deployment_2.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Gast")
public class Gast implements Serializable, GenericEntity<Gast> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Gast_ID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email")
    private String email;

    @Override
    public Long getId(){
        return this.id;
    }

    @Override
    public void update(Gast source) {
        this.name = source.getName();
        this.email = source.getEmail();
    }

    @Override
    public Gast createNewInstance() {
        Gast newInstance = new Gast();
        newInstance.update(this);
        return newInstance;
    }
}