package com.example.ha_web_deployment_2.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Film")
public class Film implements Serializable, GenericEntity<Film> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Film_ID")
    private Long id;

    @Column(name = "Titel", nullable = false)
    private String titel;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Dauer", nullable = false)
    private Double dauer;

    @Override
    public Long getId(){
        return this.id;
    }

    @Override
    public void update(Film source) {
        this.titel = source.getTitel();
        this.genre = source.getGenre();
        this.dauer = source.getDauer();
    }

    @Override
    public Film createNewInstance() {
        Film newInstance = new Film();
        newInstance.update(this);
        return newInstance;
    }
}