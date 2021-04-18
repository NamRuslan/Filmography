package com.namruslan.filmography.model;

import lombok.Data;

@Data
public class Film {

    private int id;
    private String title;
    private int year;
    private String genre;
    private boolean watched;

    @Override
    public String toString() {
        return id + " " + title + ' ' + year + ' ' + genre + ' ' + watched;
    }
}
