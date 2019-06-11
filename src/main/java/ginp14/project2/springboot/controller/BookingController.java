package ginp14.project2.springboot.controller;

import ginp14.project2.springboot.entity.Movie;
import ginp14.project2.springboot.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/processbooking")
    public String showBookingPage(@RequestParam(name = "movieId") int movieId, @RequestParam(name = "date") String date, @RequestParam(name = "show-time-time") String time, Model model) {
        Movie movie = movieService.findById(movieId);
        model.addAttribute("movie",movie);
        model.addAttribute("date",date);
        model.addAttribute("time",time);
        return "views/booking";
    }
}
