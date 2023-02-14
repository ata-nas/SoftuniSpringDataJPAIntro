package com.softuni.springintroexercises.domain.entities;

import jakarta.persistence.*;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
@Table(
        name = "authors",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"first_name", "last_name"})
        })
public class Author extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.EAGER)
    private final Set<Book> bookSet;

}
