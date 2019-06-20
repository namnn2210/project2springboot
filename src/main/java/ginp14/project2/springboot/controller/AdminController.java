package ginp14.project2.springboot.controller;

import ginp14.project2.springboot.entity.*;
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
//        System.out.println(showTimeService.findNearestShowtimeAfter("09:05:00","2019-06-11",1));
        message = "";
        return "views/admin/showtime/list_showtime";
    }

    @PostMapping("/showtime/getShowtimes")
    public @ResponseBody List<ShowTime> getShowtimesByDateAndRoomId(@RequestBody FindCriteria find_data) {
        String newDateAarr[] = find_data.getDate().split("/");
        StringBuilder sb = new StringBuilder();
        sb.append(newDateAarr[2]).append("-").append(newDateAarr[0]).append("-").append(newDateAarr[1]);
        System.out.println(showTimeService.findByDateAndRoomId(sb.toString(),find_data.getId()).size());
        System.out.println(sb.toString() + " - " + find_data.getId());
        return showTimeService.findByDateAndRoomId(sb.toString(),find_data.getId());
    }

    @GetMapping("/showtime/create")
    public String showAdminShowtimeCreateForm(Model model){
        ShowTime showTime = new ShowTime();
        List<Movie> movieList = movieService.findAll();
        model.addAttribute("showtime",showTime);
        model.addAttribute("movieList", movieList);
        return "views/admin/showtime/create_showtime";
    }

    @PostMapping("/showtime/checkShowtime")
    public @ResponseBody String checkShowtime(@RequestBody FindCriteria find_data) {
        ShowTime showTimeBefore = showTimeService.findNearestShowtimeBefore(find_data.getTime(), find_data.getDate(), find_data.getId());
        ShowTime showTimeAfter = showTimeService.findNearestShowtimeAfter(find_data.getTime(), find_data.getDate(), find_data.getId());
        System.out.println(find_data.getId());
        System.out.println(showTimeAfter);
        System.out.println(showTimeBefore);
        if (showTimeAfter == null && showTimeBefore == null){
            return "true";
        }
        // Startime
        String startTime = find_data.getTime();
        // Endtime
        Movie movie = movieService.findById(find_data.getId2());
        int duration = movie.getDuration();
        String endTime = getEndTime(startTime,duration);

        String startTimeAfter="";
        String endTimeBefore="";
        if (showTimeAfter != null){
            startTimeAfter = showTimeAfter.getTime();
        }

        if (showTimeBefore != null) {
            endTimeBefore = getEndTime(showTimeBefore.getTime(), showTimeBefore.getMovie().getDuration());
        }

        if (checkGreaterDate(startTime, endTimeBefore) && checkGreaterDate(startTimeAfter,endTime)){
            return "true";
        } else if (showTimeAfter == null && checkGreaterDate(startTime, endTimeBefore)){
            return "true";
        } else if (showTimeBefore == null && checkGreaterDate(startTimeAfter,endTime)){return "true";}

        return "false";
    }

    // if time1 >= time2 return true
    public boolean checkGreaterDate(String time1, String time2){
        if (time1 == "" || time2 == ""){
            return false;
        }
        String[] time1Arr = time1.split(":");
        int hour1 = Integer.parseInt(time1Arr[0]);
        int minute1 = Integer.parseInt(time1Arr[1]);
        String[] time2Arr = time2.split(":");
        int hour2 = Integer.parseInt(time2Arr[0]);
        int minute2 = Integer.parseInt(time2Arr[1]);

        if (hour1 > hour2 || (hour1 == hour2 && minute1 >= minute2)){
            return true;
        }

        return false;
    }

    public String getEndTime(String time, int duration){
        while(duration % 5 != 0){
            duration +=1;
        }
        duration += 10;
        String[] timeArr = time.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1])+duration;
        while (minute>=60){
            hour += 1;
            minute -=60;
        }
        return hour+":"+minute+":00";
    }
}
