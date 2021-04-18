package com.namruslan.filmography.controller;

import com.namruslan.filmography.model.Film;
import com.namruslan.filmography.service.interfaces.FilmCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmController {

    @Autowired
    private FilmCrud filmCrud;

    @GetMapping("/")
    public String filmPage() {
        return "film";
    }

    @GetMapping("/edit")
    public String editPage() {
        return "editPage";
    }

    @GetMapping("/allFilms")
    public String allFilms(Model model) {
        model.addAttribute("films", filmCrud.getAllFilms());
        return "allFilms";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable(name = "id") int id) {
        filmCrud.delete(filmCrud.getById(id));
        return "redirect:/allFilms";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable(name = "id") int id, Model model){
        model.addAttribute("film", filmCrud.getById(id));
        return "editPage";
    }

    @PostMapping("/edit/{id}")
    public String postEditPage(@ModelAttribute(name = "film") Film film, @PathVariable(name = "id") int id) {
        filmCrud.update(film);
        return "redirect:/allFilms";
    }

    @GetMapping("/add")
    public String getAddFilm(Model model) {
        model.addAttribute("film", new Film());
        return "addFilm";
    }

    @PostMapping("/add")
    public String postAddFilm(@ModelAttribute(name = "film") Film film) {
        filmCrud.create(film);
        return "redirect:/allFilms";
    }
}
