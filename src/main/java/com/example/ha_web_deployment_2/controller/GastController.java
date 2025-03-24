package com.example.ha_web_deployment_2.controller;

import com.example.ha_web_deployment_2.models.Gast;
import com.example.ha_web_deployment_2.repository.GastRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gast")
public class GastController extends GenericController<Gast> {

    public GastController(GastRepository gastRepository) {
        super(gastRepository);
    }
}