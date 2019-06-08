package ginp14.project2.springboot.controller;

import ginp14.project2.springboot.entity.Category;
import ginp14.project2.springboot.entity.Movie;
import ginp14.project2.springboot.entity.ShowTime;
import ginp14.project2.springboot.entity.User;
import ginp14.project2.springboot.service.CategoryService;
import ginp14.project2.springboot.service.MovieService;
import ginp14.project2.springboot.service.ShowTimeService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private String message = "";
    private int editMovieId;

    @Autowired
    private MovieService movieService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/home")
    public String showAdminDashboard() {
        return "views/admin/dashboard";
    }

    //  All Movie's mapping
    @GetMapping("/movie")
    public String showAdminMovie(Model model) {
        List<Movie> movieList = movieService.findAll();
        List<Category> categoryList = categoryService.findAll();
        for (Movie movie : movieList) {
            movie.setTrailer(movie.getTrailer().replace("watch?v=", "embed/"));
        }
        model.addAttribute("movieList", movieList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("message", message);
        message = "";
        return "views/admin/movie/list_movie";
    }

    @GetMapping("/movie/create")
    public String showAdminMovieCreateForm(Model model) {
        List<Category> categoryList = categoryService.findAll();
        Movie movie = new Movie();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("movie", movie);
        model.addAttribute("message", message);
        message = "";
        return "views/admin/movie/create_movie";
    }

    @GetMapping("/movie/edit")
    public String showAdminMovieEditForm(@RequestParam int movieId, Model model) {
        Movie movie = movieService.findById(movieId);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("movie", movie);
        model.addAttribute("categoryList", categoryList);
        editMovieId = movieId;
        return "views/admin/movie/edit_movie";
    }

    @PostMapping("/movie/create-process")
    public String processMovieCreate(@Valid @ModelAttribute("movie") Movie movie, Model model) {

        try {
            movie.setStatus(1);
            movieService.save(movie);
            message = "Create Successful";
        } catch (HibernateException e) {
            message = "Create Fail";
        }
        return "redirect:create";
    }

    @PostMapping("/movie/edit-process")
    public String processMovieEdit(@Valid @ModelAttribute("movie") Movie movie, Model model) {
        try {
            movieService.save(movie);
            message = "Edit Successful";
        } catch (Exception e) {
            message = "Edit Fail";
        }
        editMovieId = 0;
        return "redirect:";
    }

    @GetMapping("/movie/delete")
    public String processMovieDelete(@RequestParam int movieId, Model model) {
        try {
            movieService.deleteById(movieId);
            message = "Delete Successful";
        } catch (Exception e) {
            message = "Delete Fail";
        }
        return "redirect:";
    }



    //    ALL category's mapping
    @GetMapping("/category")
    public String showAdminCategory(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("message", message);
        model.addAttribute("categoryList", categoryList);
        message="";
        return "views/admin/category/list_category";
    }

    @GetMapping("/category/create")
    public String showAdminCategoryCreateForm(Model model) {
        Category category = new Category();
        model.addAttribute("category",category);
        model.addAttribute("message", message);
        message = "";
        return "views/admin/category/create_category";
    }

    @PostMapping("/category/create-process")
    public String processCategoryCreate(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "views/admin/category/create_category";
        }
        try {
            categoryService.save(category);
            message = "Create Successful";
            return "redirect:create";
        } catch (HibernateException e) {
            message = "Create Fail";
            return "redirect:create";
        }
    }

    @GetMapping("/category/edit")
    public String showAdminCategoryEditForm(@RequestParam int catId, Model model) {
        Category category = categoryService.findById(catId);
        model.addAttribute("category",category);
        return "views/admin/category/edit_category";
    }

    @PostMapping("/category/edit-process")
    public String processCategoryEdit(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "redirect:edit";
        }
        try {
            categoryService.save(category);
            message = "Edit Successful";
            return "redirect:";
        } catch (HibernateException e) {
            message = "Edit Fail";
            return "redirect:";
        }
    }

    @GetMapping("/category/delete")
    public String processCategoryDelete(@RequestParam int catId, Model model){
        try {
            categoryService.deleteById(catId);
            message = "Delete Successful";
        } catch (Exception e) {
            message = "Delete Fail";
        }
        return "redirect:";
    }

    // Showtime create
    @GetMapping("/showtime")
    public String showShowtime(Model model){
        List<ShowTime> showTime = showTimeService.findAll();
        model.addAttribute("listShowTime",showTime);
        model.addAttribute("message",message);
        return "views/admin/showtime/list_showtime";
    }
}
