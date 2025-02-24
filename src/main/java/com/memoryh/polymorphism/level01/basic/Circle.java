package com.memoryh.polymorphism.level01.basic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circle extends Shape implements Resizable {

    private double radius;

    @Override
    public void resize(final double factor) {
        this.radius = factor * radius;
    }

    // 넓이
    @Override
    double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    // 둘레
    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

}