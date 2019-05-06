package ginp14.project2.springboot.service;

import ginp14.project2.springboot.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public void save(Category category);
    public Category findById(int id);
    public void deleteById(int id);
}
