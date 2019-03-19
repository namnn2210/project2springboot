package ginp14.project2.springboot.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "gender")
    private int gender;
    @Column(name = "DOB")
    private Date DOB;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "point")
    private int point;
    @Column(name = "status")
    private int status;
    @Column(name = "created_at")
    private Timestamp created_at;
    @Column(name = "updated_at")
    private Timestamp updated_at;
    private int role_id;
}
