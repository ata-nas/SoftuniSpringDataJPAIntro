package com.softuni.springintroexercises.services.author;

import com.softuni.springintroexercises.domain.entities.Author;
import com.softuni.springintroexercises.exeptions.NoSuchBookFoundException;
import com.softuni.springintroexercises.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors(Set<Author> authors) {
        this.authorRepository.saveAll(authors);
    }

    @Override
    public Author getRandomAuthor() {
        List<Author> authors = authorRepository.findAll();

        return authors.get(ThreadLocalRandom.current().nextInt(authors.size()));
    }

    @Override
    public List<Author> findAllByBookSetReleaseDateBefore(LocalDate date) {
        return authorRepository.findAllByBookSetReleaseDateBefore(date)
                .orElseThrow(NoSuchBookFoundException::new);
    }

    @Override
    public List<Author> getAuthorsByCountBookSet() {
        return authorRepository.getAuthorsByCountBookSet()
                .orElseThrow(NoSuchBookFoundException::new);
    }

}
