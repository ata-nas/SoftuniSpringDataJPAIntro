package com.softuni.springintroexercises.domain.entities;

import com.softuni.springintroexercises.domain.enums.AgeRestricitonEnum;
import com.softuni.springintroexercises.domain.enums.EditionTypeEnum;

import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false, name = "edition_type")
    @Enumerated(EnumType.STRING)
    private EditionTypeEnum editionTypeEnum;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "age_restriction", nullable = false)
    @Enumerated(EnumType.STRING)
    private AgeRestricitonEnum ageRestricitonEnum;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinTable(
            name = "books_categories",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")}
    )
    private Set<Category> categorySet;

}
