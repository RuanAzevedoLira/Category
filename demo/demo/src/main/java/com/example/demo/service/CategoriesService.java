package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categories;
import com.example.demo.repository.CategoriesRepository;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    //Cread

    public Categories saveCategories(Categories category) {
        return categoriesRepository.save(category);
    }

        // Read

        public List<Categories> findAll () {
            return categoriesRepository.findAll();
        }
    
        public Optional<Categories> findById(Long id) {
            return categoriesRepository.findById(id);
        }
    
        public Categories findByName(String name) {
            return categoriesRepository.findByName(name);
        }
    

    // Update

    // Update
    public Categories updateById(Long id, Categories category) {
        if (categoriesRepository.existsById(id)) {
            category.setId(id);
            return categoriesRepository.save(category);
        } else {
            throw new IllegalArgumentException("Category with id " + id + " does not exist.");
        }
    }

    public Categories updateByName(String name, Categories newCategory) {
        Categories existingCategory = categoriesRepository.findByName(name);
        if (existingCategory != null) {
            newCategory.setId(existingCategory.getId());
            return categoriesRepository.save(newCategory);
        } else {
            throw new IllegalArgumentException("Category with name " + name + " does not exist.");
        }
    }

    //Delete

    public void deleteById (Long id){
        categoriesRepository.deleteById(id);
    }

    public void deleteByName (String name) {
        categoriesRepository.deleteByName(name);
    }
}

