package com.memoryh.stream.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {

    private String title;
    private String genre;
    private double rating;
    private int duration;

}