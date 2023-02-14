package com.softuni.springintroexercises.services.author;

import com.softuni.springintroexercises.domain.entities.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AuthorService {

    void seedAuthors(Set<Author> authors);

    Author getRandomAuthor();

    List<Author> findAllByBookSetReleaseDateBefore(LocalDate date);

    List<Author> getAuthorsByCountBookSet();

}
