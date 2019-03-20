package ginp14.project2.springboot.dao;

import ginp14.project2.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
    public Role findById(int id);
}
