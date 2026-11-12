package com.example.cw35.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public class MovieRequestDto {
    @NotNull @NotEmpty
    @Size(min = 1 , max = 100)
    private String title;

    @NotNull @NotEmpty
    private String genre;

    @NotNull @NotEmpty
    @Size(min = 1 , max = 50)
    private String  director;

    @NotNull
    private Double rating;

    @NotNull
    private Integer releaseYear;

    public MovieRequestDto() {
    }

    public MovieRequestDto(String title, String genre, String director, Double rating, Integer releaseYear) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
