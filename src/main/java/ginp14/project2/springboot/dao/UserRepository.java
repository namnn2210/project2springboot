package ginp14.project2.springboot.dao;

import ginp14.project2.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String username);
}
