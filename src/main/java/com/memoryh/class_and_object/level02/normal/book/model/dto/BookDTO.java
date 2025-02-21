package com.memoryh.class_and_object.level02.normal.book.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    public BookDTO(final String title, final String publisher,final String author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    @Override
    public String toString() {
        return this.title + ", " + this.publisher + ", " + this.author + ", " + this.price + ", " + this.discountRate;
    }

}