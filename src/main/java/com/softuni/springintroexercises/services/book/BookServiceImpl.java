package com.softuni.springintroexercises.services.book;

import com.softuni.springintroexercises.domain.entities.Book;
import com.softuni.springintroexercises.exeptions.NoSuchBookFoundException;
import com.softuni.springintroexercises.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl  implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooks(Set<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public List<Book> findAllByReleaseDateAfter(LocalDate date) {
        return bookRepository.findAllByReleaseDateAfter(date)
                .orElseThrow(NoSuchBookFoundException::new);
    }

    @Override
    public List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDesc(String authorFirstName, String authorLastName) {
        return bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDesc(authorFirstName, authorLastName)
                .orElseThrow(NoSuchBookFoundException::new);
    }

}
