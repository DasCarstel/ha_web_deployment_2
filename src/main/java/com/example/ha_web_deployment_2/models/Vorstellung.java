package com.example.ha_web_deployment_2.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Vorstellung")
public class Vorstellung implements Serializable, GenericEntity<Vorstellung> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Vorstellungs_ID")
    private Long id;

    @Column(name = "Film_ID", nullable = false)
    private Long filmId;

    @Column(name = "Vorfuehrungszeit", nullable = false)
    private LocalDateTime vorfuehrungszeit;

    @Column(name = "Saal_ID", nullable = false)
    private Long saalId;

    @Override
    public Long getId(){
        return this.id;
    }

    @Override
    public void update(Vorstellung source) {
        this.filmId = source.getFilmId();
        this.vorfuehrungszeit = source.getVorfuehrungszeit();
        this.saalId = source.getSaalId();
    }

    @Override
    public Vorstellung createNewInstance() {
        Vorstellung newInstance = new Vorstellung();
        newInstance.update(this);
        return newInstance;
    }
}