package com.softuni.springintroexercises;

import com.softuni.springintroexercises.domain.entities.Author;
import com.softuni.springintroexercises.domain.entities.Book;

import com.softuni.springintroexercises.services.author.AuthorService;
import com.softuni.springintroexercises.services.book.BookService;
import com.softuni.springintroexercises.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunnerImpl implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunnerImpl(
            SeedService seedService,
            BookService bookService,
            AuthorService authorService)
    {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) {
        seedService.seedAll();

        List<Book> bookList = bookService.findAllByReleaseDateAfter(LocalDate.of(2000, 1, 1));
        bookList.forEach(book -> System.out.println(book.getTitle()));

        List<Author> allByBookSetReleaseDateBefore = authorService.findAllByBookSetReleaseDateBefore(LocalDate.of(1990, 1, 1));
        allByBookSetReleaseDateBefore.forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

        List<Author> authorsByBookCount = authorService.getAuthorsByCountBookSet();
        authorsByBookCount.forEach(author -> System.out.println(author.getFirstName() + " " + author.getBookSet().size()));

        List<Book> allByAuthorNameOrderReleaseDesc = bookService.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDesc(
                "George", "Powell");
        allByAuthorNameOrderReleaseDesc.forEach(book -> System.out.println(
                book.getTitle() + " " + book.getReleaseDate() + " " + book.getCopies()));
    }

}
