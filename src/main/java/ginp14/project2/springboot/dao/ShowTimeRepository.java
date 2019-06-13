package ginp14.project2.springboot.dao;

import ginp14.project2.springboot.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    public ShowTime findByMovieId(int movieId);
    public List<ShowTime> findByDateAndMovieId(String date, int movieId);
    public List<ShowTime> findByDateAndRoomId(String date, int roomId);

}
