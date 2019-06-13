package ginp14.project2.springboot.service;

import ginp14.project2.springboot.dao.ShowTimeRepository;
import ginp14.project2.springboot.entity.ShowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeServiceImp implements ShowTimeService {

    @Autowired
    private ShowTimeRepository showTimeRepository;

    @Override
    public List<ShowTime> findAll() {
        return showTimeRepository.findAll();
    }

    @Override
    public void save(ShowTime showTime) {

    }

    @Override
    public void findById(int id) {

    }

    @Override
    public ShowTime findByMovieId(int movieId) {
        return showTimeRepository.findByMovieId(movieId);
    }

    @Override
    public List<ShowTime> findByDateAndMovieId(String date,int movieId) {
        return showTimeRepository.findByDateAndMovieId(date,movieId);
    }

    @Override
    public List<ShowTime> findByDateAndRoomId(String date, int roomId){
        return showTimeRepository.findByDateAndRoomId(date, roomId);
    }
}
