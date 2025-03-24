package com.example.ha_web_deployment_2.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable, GenericEntity<Ticket> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Ticket_ID")
    private Long id;

    @Column(name = "Vorstellungs_ID", nullable = false)
    private Long vorstellungsId;

    @Column(name = "Gast_ID", nullable = false)
    private Long gastId;

    @Column(name = "Platz_Typ", nullable = false)
    private Boolean platzTyp; // FALSE = Parkett, TRUE = Loge

    @Override
    public Long getId(){
        return this.id;
    }

    @Override
    public void update(Ticket source) {
        this.vorstellungsId = source.getVorstellungsId();
        this.gastId = source.getGastId();
        this.platzTyp = source.getPlatzTyp();
    }

    @Override
    public Ticket createNewInstance() {
        Ticket newInstance = new Ticket();
        newInstance.update(this);
        return newInstance;
    }
}