package com.example.cw35.dto;

public class MovieResponseDto {
    private Long id;


    private String title;

    private String director;

    private String genre;

    private Double rate;

    private Integer releaseYear;

    public MovieResponseDto() {
    }

    public MovieResponseDto(Long id, String title, String director, String genre, Double rate, Integer releaseYear) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.rate = rate;
        this.releaseYear = releaseYear;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

