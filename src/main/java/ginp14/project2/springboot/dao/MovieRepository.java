package ginp14.project2.springboot.dao;

import ginp14.project2.springboot.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
