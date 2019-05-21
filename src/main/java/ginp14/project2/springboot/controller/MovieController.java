package ginp14.project2.springboot.controller;

import ginp14.project2.springboot.entity.Movie;
import ginp14.project2.springboot.service.MovieService;
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

    @GetMapping("/detail")
    public String showMovieDetail(@RequestParam int movieId, Model model) {
        Movie movie = movieService.findById(movieId);
        movie.setTrailer(movie.getTrailer().replace("watch?v=","embed/"));
        model.addAttribute("movie",movie);
        return "views/movies/movie_detail";
    }
}
