package ginp14.project2.springboot.service;

import ginp14.project2.springboot.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {
    public List<ShowTime> findAll();
    public void save(ShowTime showTime);
    public void findById(int id);
    public ShowTime findByMovieId(int movieId);
}
