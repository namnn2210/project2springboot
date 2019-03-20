package ginp14.project2.springboot.service;

import ginp14.project2.springboot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();
    public void save(User user);
    public void deleteById(int id);
    public boolean isUserPresent(String username);
}
