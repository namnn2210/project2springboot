package ginp14.project2.springboot.dao;

import ginp14.project2.springboot.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {
    public ShowTime findByMovieId(int movieId);
}
