package com.softuni.springintroexercises.services.category;

import com.softuni.springintroexercises.domain.entities.Category;
import com.softuni.springintroexercises.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories(Set<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public Set<Category> getRandomCategories() {
        List<Category> categories = categoryRepository.findAll();

        int rep = ThreadLocalRandom.current().nextInt(categories.size());

        Set<Category> result = new HashSet<>();

        for (int i = 0; i < rep; i++) {
            int random = ThreadLocalRandom.current().nextInt(categories.size());

            result.add(categories.get(random));
        }

        return result;
    }

}
