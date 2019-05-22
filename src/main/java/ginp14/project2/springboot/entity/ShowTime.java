package ginp14.project2.springboot.entity;


import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class ShowTime {

    @Column(name = "date")
    @NotNull(message = "This field cannot be blank")
    private String date;

    @Column(name = "time")
    @NotNull(message = "This field cannot be blank")
    private String time;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @NotNull(message = "This field cannot be blank")
    private Movie movie;

    public ShowTime() {
    }

    public ShowTime(@NotNull(message = "This field cannot be blank") String date, @NotNull(message = "This field cannot be blank") String time, @NotNull(message = "This field cannot be blank") Movie movie) {
        this.date = date;
        this.time = time;
        this.movie = movie;
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

    @Override
    public String toString() {
        return "ShowTime{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", movie=" + movie +
                '}';
    }
}
