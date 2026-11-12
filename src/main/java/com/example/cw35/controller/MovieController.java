package com.example.cw35.controller;

import com.example.cw35.dto.MovieRequestDto;
import com.example.cw35.dto.MovieResponseDto;
import com.example.cw35.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
@Validated
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponseDto> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> findById(@PathVariable Long id) {
        MovieResponseDto byId = movieService.findById(id);
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId);

    }

    @PostMapping("/save")
    public ResponseEntity<MovieResponseDto> save(@Valid @RequestBody MovieRequestDto movieRequestDto) {
         movieService.save(movieRequestDto);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        MovieResponseDto byId = movieService.findById(id);
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        movieService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponseDto>> findByDirector(@RequestParam String director) {
        List<MovieResponseDto> movies = movieService.findByDirector(director);
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/byGenre")
    public ResponseEntity<List<MovieResponseDto>> findByGenre(@RequestParam String genre) {
        List<MovieResponseDto> byGenre = movieService.findByGenre(genre);
        if (byGenre.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byGenre);
    }

    @GetMapping("/byTitle")
    public ResponseEntity<List<MovieResponseDto>> findByTitle(@RequestParam String title){
        List<MovieResponseDto> movieResponseDto = movieService.searchByTitle(title);
        if(movieResponseDto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieResponseDto);
    }

}
