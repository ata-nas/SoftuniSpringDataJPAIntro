package com.softuni.springintroexercises.constants;

public enum FilePath {

    BOOKS_DB_INSERT_PATH(FilePath.BOOK_FILENAME),
    CATEGORIES_DB_INSERT_PATH(FilePath.CATEGORY_FILENAME),
    AUTHORS_DB_INSERT_PATH(FilePath.AUTHOR_FILENAME);

    private static final String RESOURCE_URL = "src/main/resources/dbContent/";
    private static final String BOOK_FILENAME = RESOURCE_URL + "books.txt";
    private static final String CATEGORY_FILENAME = RESOURCE_URL + "categories.txt";
    private static final String AUTHOR_FILENAME = RESOURCE_URL + "authors.txt";

    public final String PATH;

     FilePath(String url) {
        this.PATH = url;
    }

}
