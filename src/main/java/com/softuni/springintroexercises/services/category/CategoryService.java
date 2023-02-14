package com.softuni.springintroexercises.services.category;

import com.softuni.springintroexercises.domain.entities.Category;

import java.util.Set;

public interface CategoryService {

    void seedCategories(Set<Category> categories);

    Set<Category> getRandomCategories();

}
