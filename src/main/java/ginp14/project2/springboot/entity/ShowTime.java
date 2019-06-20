package ginp14.project2.springboot.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "show_times")
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "This field cannot be blank")
    private int id;

    @Column(name = "date")
    @NotNull(message = "This field cannot be blank")
    private String date;

    @Column(name = "time")
    @NotNull(message = "This field cannot be blank")
    private String time;

    @Column(name = "room_id")
    @NotNull(message = "This field cannot be blank")
    private int roomId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @NotNull(message = "This field cannot be blank")
    private Movie movie;

    public ShowTime() {
    }

    public ShowTime(@NotNull(message = "This field cannot be blank") String date, @NotNull(message = "This field cannot be blank") String time, @NotNull(message = "This field cannot be blank") Movie movie, @NotNull(message = "This field cannot be blank") int roomId) {
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "ShowTime{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", roomId=" + roomId +
                ", movie=" + movie +
                '}';
    }
}
