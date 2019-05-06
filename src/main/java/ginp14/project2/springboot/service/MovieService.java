package ginp14.project2.springboot.service;

import ginp14.project2.springboot.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> findAll();
    public void save(Movie movie);
    public Movie findById(int id);
    public void deleteById(int id);

}
