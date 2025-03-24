package com.example.ha_web_deployment_2.controller;

import com.example.ha_web_deployment_2.models.Vorstellung;
import com.example.ha_web_deployment_2.repository.VorstellungRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vorstellung")
public class VorstellungController extends GenericController<Vorstellung> {

    public VorstellungController(VorstellungRepository vorstellungRepository) {
        super(vorstellungRepository);
    }
}