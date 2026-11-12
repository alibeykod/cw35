package com.example.cw35.repository;

import com.example.cw35.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

List<Movie> findMovieByDirector(String directorName);

List<Movie> findByGenre(String genre);

@Query("SELECT m FROM Movie m WHERE m.title = :title")
List<Movie> searchByTitle(@Param("title") String title);
}
