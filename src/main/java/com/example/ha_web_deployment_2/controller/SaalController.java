package com.example.ha_web_deployment_2.controller;

import com.example.ha_web_deployment_2.models.Saal;
import com.example.ha_web_deployment_2.repository.SaalRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saal")
public class SaalController extends GenericController<Saal> {

    public SaalController(SaalRepository saalRepository) {
        super(saalRepository);
    }
}