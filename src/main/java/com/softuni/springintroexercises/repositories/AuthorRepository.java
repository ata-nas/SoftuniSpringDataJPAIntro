package com.softuni.springintroexercises.repositories;

import com.softuni.springintroexercises.domain.entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Override
    List<Author> findAll();
    Optional<List<Author>> findAllByBookSetReleaseDateBefore(LocalDate date);

    @Query(
            "SELECT a FROM Author a JOIN a.bookSet bs ORDER BY size(bs) DESC"
    )
    Optional<List<Author>> getAuthorsByCountBookSet();

}
