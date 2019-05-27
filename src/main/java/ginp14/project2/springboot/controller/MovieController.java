package ginp14.project2.springboot.controller;

import ginp14.project2.springboot.entity.Movie;
import ginp14.project2.springboot.entity.ShowTime;
import ginp14.project2.springboot.service.MovieService;
import ginp14.project2.springboot.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/detail")
    public String showMovieDetail(@RequestParam int movieId, Model model) {
        Movie movie = movieService.findById(movieId);
        movie.setTrailer(movie.getTrailer().replace("watch?v=","embed/"));
        ShowTime movie_showtimes = showTimeService.findByMovieId(movie.getId());
        model.addAttribute("movie",movie);
        model.addAttribute("movie_showtimes",movie_showtimes);
        return "views/movies/movie_detail";
    }
}
