package ginp14.project2.springboot.service;

import ginp14.project2.springboot.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void save(Category category) {
        categoryService.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryService.findById(id);
    }

    @Override
    public void deleteById(int id) {

    }
}
