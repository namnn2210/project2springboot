package ginp14.project2.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {


    @GetMapping("/detail")
    public String showMovieDetail() {
        return "views/movies/movie_detail";
    }
}
