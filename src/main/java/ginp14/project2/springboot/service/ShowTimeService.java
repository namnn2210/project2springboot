package ginp14.project2.springboot.service;

import ginp14.project2.springboot.entity.ShowTime;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowTimeService {
    public List<ShowTime> findAll();
    public void save(ShowTime showTime);
    public void findById(int id);
    public ShowTime findByMovieId(int movieId);
    public List<ShowTime> findByDateAndMovieId(String date, int movieId);
    public List<ShowTime> findByDateAndRoomId(String date, int roomId);
    public ShowTime findNearestShowtimeAfter(String time, String date, int roomId);
    public ShowTime findNearestShowtimeBefore(String time, String date, int roomId);
}
