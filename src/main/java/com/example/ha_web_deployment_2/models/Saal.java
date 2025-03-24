package com.example.ha_web_deployment_2.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Saal")
public class Saal implements Serializable, GenericEntity<Saal> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Saal_ID")
    private Long id;

    @Column(name = "max_Parkettplaetze", nullable = false)
    private Integer maxParkettplaetze;

    @Column(name = "max_Logenplaetze", nullable = false)
    private Integer maxLogenplaetze;

    @Column(name = "Ausstattung")
    private String ausstattung;

    @Override
    public Long getId(){
        return this.id;
    }

    @Override
    public void update(Saal source) {
        this.maxParkettplaetze = source.getMaxParkettplaetze();
        this.maxLogenplaetze = source.getMaxLogenplaetze();
        this.ausstattung = source.getAusstattung();
    }

    @Override
    public Saal createNewInstance() {
        Saal newInstance = new Saal();
        newInstance.update(this);
        return newInstance;
    }
}