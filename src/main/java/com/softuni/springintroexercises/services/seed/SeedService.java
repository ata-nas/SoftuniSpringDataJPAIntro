package com.softuni.springintroexercises.services.seed;

import jakarta.transaction.Transactional;

public interface SeedService {

    void seedAuthors();

    void seedBooks();

    void seedCategories();

    @Transactional
    default void seedAll() {
        seedAuthors();
        seedCategories();
        seedBooks();
    }

}
