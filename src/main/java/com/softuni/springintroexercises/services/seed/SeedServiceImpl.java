package com.softuni.springintroexercises.services.seed;

import com.softuni.springintroexercises.constants.FilePath;
import com.softuni.springintroexercises.domain.entities.Author;
import com.softuni.springintroexercises.domain.entities.Book;
import com.softuni.springintroexercises.domain.entities.Category;
import com.softuni.springintroexercises.domain.enums.AgeRestricitonEnum;
import com.softuni.springintroexercises.domain.enums.EditionTypeEnum;
import com.softuni.springintroexercises.exeptions.SeedDataFileNotFoundException;
import com.softuni.springintroexercises.services.author.AuthorService;
import com.softuni.springintroexercises.services.book.BookService;
import com.softuni.springintroexercises.services.category.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public SeedServiceImpl(AuthorService authorService,
                           BookService bookService,
                           CategoryService categoryService)
    {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedAuthors() {
        Scanner sc = getScannerForDBInputFile(FilePath.AUTHORS_DB_INSERT_PATH.PATH);

        Set<Author> authorSet = new HashSet<>();

        while (sc.hasNext()) {
            String[] names = sc.nextLine().trim().split("\\s+");

            Author author = Author.builder()
                    .firstName(names[0])
                    .lastName(names[1])
                    .build();

            authorSet.add(author);
        }

        authorService.seedAuthors(authorSet);
    }

    @Override
    public void seedBooks() {
        Scanner sc = getScannerForDBInputFile(FilePath.BOOKS_DB_INSERT_PATH.PATH);

        Set<Book> bookSet = new HashSet<>();

        while (sc.hasNext()) {
            String[] data = sc.nextLine().trim().split("\\s+");

            Author author = authorService.getRandomAuthor();

            Set<Category> bookCategories = categoryService.getRandomCategories();

            EditionTypeEnum editionType = EditionTypeEnum
                    .values()[Integer.parseInt(data[0])];

            LocalDate releaseDate = LocalDate.parse(data[1],
                    DateTimeFormatter.ofPattern("d/M/yyyy"));

            Integer copies = Integer.parseInt(data[2]);

            BigDecimal price = new BigDecimal(data[3]);

            AgeRestricitonEnum ageRestriction = AgeRestricitonEnum
                    .values()[Integer.parseInt(data[4])];

            String title = Arrays.stream(data)
                    .skip(5)
                    .collect(Collectors.joining(" "));

            Book book = Book.builder()
                    .author(author)
                    .categorySet(bookCategories)
                    .editionTypeEnum(editionType)
                    .releaseDate(releaseDate)
                    .copies(copies)
                    .price(price)
                    .ageRestricitonEnum(ageRestriction)
                    .title(title)
                    .build();
            bookSet.add(book);
        }

        bookService.seedBooks(bookSet);
    }

    @Override
    public void seedCategories() {
        Scanner sc = getScannerForDBInputFile(FilePath.CATEGORIES_DB_INSERT_PATH.PATH);

        Set<Category> categorySet = new HashSet<>();

        while (sc.hasNext()) {
            String categoryName = sc.nextLine().trim();

            if (categoryName.equals("")) {
                continue;
            }

            Category category = Category.builder()
                    .name(categoryName)
                    .build();

            categorySet.add(category);
        }

        categoryService.seedCategories(categorySet);
    }

    private Scanner getScannerForDBInputFile(String path) {
        File file = Paths.get(path).toFile();

        Scanner sc;

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new SeedDataFileNotFoundException(
                    "No file found at " + path
            );
        }

        return sc;
    }

}
