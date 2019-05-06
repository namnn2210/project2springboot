package ginp14.project2.springboot.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @NotNull(message = "This field cannot be blank")
    private String title;

    @Column(name = "description")
    @NotNull(message = "This field cannot be blank")
    private String description;

    @Column(name = "duration")
    @NotNull(message = "This field cannot be blank")
    private int duration;

    @Column(name = "director")
    @NotNull(message = "This field cannot be blank")
    private String director;

    @Column(name = "cast")
    @NotNull(message = "This field cannot be blank")
    private String cast;

    @Column(name = "poster")
    @NotNull(message = "This field cannot be blank")
    private String poster;

    @Column(name = "trailer")
    @NotNull(message = "This field cannot be blank")
    private String trailer;

    @Column(name = "status")
    @NotNull(message = "This field cannot be blank")
    private int status;


    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "This field cannot be blank")
    private Category category;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    public Movie() {
    }

    public Movie(@NotNull(message = "This field cannot be blank") String title, @NotNull(message = "This field cannot be blank") String description, @NotNull(message = "This field cannot be blank") int duration, @NotNull(message = "This field cannot be blank") String director, @NotNull(message = "This field cannot be blank") String cast, @NotNull(message = "This field cannot be blank") String poster, @NotNull(message = "This field cannot be blank") String trailer, @NotNull(message = "This field cannot be blank") int status, @NotNull(message = "This field cannot be blank") Category category, Timestamp created_at, Timestamp updated_at) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.director = director;
        this.cast = cast;
        this.poster = poster;
        this.trailer = trailer;
        this.status = status;
        this.category = category;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", director='" + director + '\'' +
                ", cast=" + cast +
                ", poster='" + poster + '\'' +
                ", trailer='" + trailer + '\'' +
                ", status=" + status +
                ", category=" + category +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
