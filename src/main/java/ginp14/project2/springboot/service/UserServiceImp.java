package ginp14.project2.springboot.service;

import ginp14.project2.springboot.dao.RoleRepository;
import ginp14.project2.springboot.dao.UserRepository;
import ginp14.project2.springboot.entity.Role;
import ginp14.project2.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findById(1);
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean isUserPresent(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmailPresent(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return true;
        }
        return false;
    }

}
