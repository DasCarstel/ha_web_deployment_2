package com.example.ha_web_deployment_2.controller;

import com.example.ha_web_deployment_2.models.Film;
import com.example.ha_web_deployment_2.repository.FilmRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/film")
public class FilmController extends GenericController<Film> {

    public FilmController(FilmRepository filmRepository) {
        super(filmRepository);
    }
}