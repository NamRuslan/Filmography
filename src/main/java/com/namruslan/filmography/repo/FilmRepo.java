package com.namruslan.filmography.repo;

import com.namruslan.filmography.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepo extends JpaRepository<FilmEntity, Integer> {
}
