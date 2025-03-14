package com.memoryh.stream.library;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private double price;

}