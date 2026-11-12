package com.example.cw35.service;

import com.example.cw35.dto.MovieRequestDto;
import com.example.cw35.dto.MovieResponseDto;
import com.example.cw35.model.Movie;
import com.example.cw35.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieResponseDto> findAll(){
        return movieRepository.findAll().stream().map(Movie -> new MovieResponseDto(Movie.getId() , Movie.getTitle() , Movie.getDirector() , Movie.getGenre() , Movie.getRate() , Movie.getReleaseYear())).toList();
    }

    public MovieResponseDto findById(Long id){
        Optional<Movie> found =  movieRepository.findById(id);
        if (found.isPresent()){
            Movie movieToDto = found.get();
            return new MovieResponseDto(id ,movieToDto.getTitle(), movieToDto.getDirector() , movieToDto.getGenre() , movieToDto.getRate() , movieToDto.getReleaseYear() );
        }
        return null;
    }

    public MovieResponseDto save(MovieRequestDto movieRequestDto){
        Movie movie = Movie.builder()
                .title(movieRequestDto.getTitle())
                .director(movieRequestDto.getDirector())
                .releaseYear(movieRequestDto.getReleaseYear())
                .genre(movieRequestDto.getGenre())
                .rate(movieRequestDto.getRating())
                .build();
        movieRepository.save(movie);
        return new MovieResponseDto(movie.getId()
        ,movie.getTitle(),movie.getDirector(),movie.getGenre(),movie.getRate(),movie.getReleaseYear()
        );
    }

    public void delete(Long id){
        movieRepository.deleteById(id);
    }

    public List<MovieResponseDto> findByDirector(String director){
       return movieRepository.findMovieByDirector(director).stream().map(Movie -> new MovieResponseDto(Movie.getId() , Movie.getTitle() , Movie.getDirector() , Movie.getGenre() , Movie.getRate() , Movie.getReleaseYear())).toList();
    }

    public List<MovieResponseDto> findByGenre(String genre){
        return movieRepository.findByGenre(genre).stream().map(Movie -> new MovieResponseDto(Movie.getId() , Movie.getTitle() , Movie.getDirector() , Movie.getGenre() , Movie.getRate() , Movie.getReleaseYear())).toList();
    }

    public List<MovieResponseDto> searchByTitle(String title){
        return movieRepository.searchByTitle(title).stream().map(Movie -> new MovieResponseDto(Movie.getId() , Movie.getTitle() , Movie.getDirector() , Movie.getGenre() , Movie.getRate() , Movie.getReleaseYear())).toList();
    }

}
