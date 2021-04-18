package com.namruslan.filmography.service.implementations;

import com.namruslan.filmography.entity.FilmEntity;
import com.namruslan.filmography.model.Film;
import com.namruslan.filmography.repo.FilmRepo;
import com.namruslan.filmography.service.interfaces.FilmCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmCrudImpl implements FilmCrud {

    @Autowired
    private FilmRepo filmRepo;

    private Film toFilm(FilmEntity filmEntity) {
        Film film = new Film();
        film.setId(filmEntity.getId());
        film.setTitle(filmEntity.getTitle());
        film.setGenre(filmEntity.getGenre());
        film.setYear(filmEntity.getYear());
        film.setWatched(filmEntity.isWatched());
        return film;
    }

    private FilmEntity toEntity(Film film) {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(film.getId());
        filmEntity.setTitle(film.getTitle());
        filmEntity.setGenre(film.getGenre());
        filmEntity.setYear(film.getYear());
        filmEntity.setWatched(film.isWatched());
        return filmEntity;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepo.findAll().stream()
                .map(this::toFilm)
                .collect(Collectors.toList());
    }

    @Override
    public void create(Film film) {
        filmRepo.save(toEntity(film));
    }

    @Override
    public void update(Film film) {
        FilmEntity filmEntity = filmRepo.getOne(film.getId());
        filmEntity.setTitle(film.getTitle());
        filmEntity.setGenre(film.getGenre());
        filmEntity.setYear(film.getYear());
        filmEntity.setWatched(film.isWatched());
        filmRepo.save(filmEntity);
    }

    @Override
    public void delete(Film film) {
        filmRepo.deleteById(film.getId());
    }

    @Override
    public Film getById(int id) {
        return toFilm(filmRepo.getOne(id));
    }
}
