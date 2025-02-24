package com.memoryh.polymorphism.level01.basic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangle extends Shape implements Resizable {

    private double width;
    private double height;

    @Override
    public void resize(final double factor) {
        this.width = width * factor;
        this.height = height * factor;
    }

    // 넓이
    @Override
    double calculateArea() {
        return width * height;
    }

    // 둘레
    @Override
    double calculatePerimeter() {
        return 2 * (width + height);
    }

}