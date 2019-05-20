package ginp14.project2.springboot.service;

import ginp14.project2.springboot.dao.MovieRepository;
import ginp14.project2.springboot.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Movie findById(int id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }
}
