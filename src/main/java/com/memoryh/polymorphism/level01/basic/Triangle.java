package com.memoryh.polymorphism.level01.basic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle extends Shape implements Resizable {

    private double base; // 밑변
    private double height; // 높이
    private double side1; // 첫 번째 변
    private double side2; // 두 번째 변
    private double side3; // 세 번째 변

    @Override
    public void resize(final double factor) {
        this.base = base * factor;
        this.height = height * factor;
        this.side1 = side1 * factor;
        this.side2 = side2 * factor;
        this.side3 = side3 * factor;
    }

    // 넓이
    @Override
    double calculateArea() {
        return base * height / 2;
    }

    // 둘레
    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }

}