package com.softuni.springintroexercises.services.book;

import com.softuni.springintroexercises.domain.entities.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks(Set<Book> books);

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDesc(String authorFirstName, String authorLastName);

}
