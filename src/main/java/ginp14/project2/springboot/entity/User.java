package ginp14.project2.springboot.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotBlank(message = "This field cannot be blank")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "This field cannot be blank")
    @Size(min = 5, message = "Password is too short")
    private String password;

    @NotBlank(message = "This field cannot be blank")
    @Column(name = "full_name")
    private String fullname;


    @Column(name = "gender")
    @NotNull(message = "Please select gender")
    private int gender;

    @Column(name = "address")
    private String address;


    @Column(name = "email")
    @NotBlank(message = "This field cannot be blank")
    @Email(message = "This is not a valid email")
    private String email;

    @Column(name = "dob")
    private String DOB;


    @Column(name = "telephone")
    @NotBlank(message = "This field cannot be blank")
    @Size(max = 11,message = "Phone number must be less than 11 digits")
    private String telephone;

    @Column(name = "points")
    private int points;

    @Column(name = "status")
    private int status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(@NotNull @Size(min = 2, max = 10) String username, @Size(min = 5, message = "is too short") String password, String fullname, int gender, String address, @Email String email, String DOB, String telephone, Timestamp created_at, Timestamp updated_at) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.DOB = DOB;
        this.telephone = telephone;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", DOB=" + DOB +
                ", telephone='" + telephone + '\'' +
                ", points=" + points +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", roles=" + roles +
                '}';
    }
}
