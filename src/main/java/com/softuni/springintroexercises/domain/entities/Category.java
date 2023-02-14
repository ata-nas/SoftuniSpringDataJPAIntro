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
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @Setter(AccessLevel.NONE)
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categorySet")
    private final Set<Book> bookSet;

}
