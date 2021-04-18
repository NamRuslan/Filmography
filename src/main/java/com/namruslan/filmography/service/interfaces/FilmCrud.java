package com.namruslan.filmography.service.interfaces;

import com.namruslan.filmography.model.Film;

import java.util.List;

public interface FilmCrud {

    List<Film> getAllFilms();

    void create(Film film);

    void update(Film film);

    void delete(Film film);

    Film getById(int id);
}
