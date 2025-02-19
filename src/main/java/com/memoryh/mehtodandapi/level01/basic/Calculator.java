package com.memoryh.mehtodandapi.level01.basic;

import java.util.stream.IntStream;

public class Calculator {

    public void checkMethod() {
        System.out.println("메소드 호출 확인");
    }

    public int sum1to10() {
        return IntStream.rangeClosed(1, 10)
                .sum();
    }

    public int checkMaxNumber(int a, int b) {
        return Math.max(a, b);
    }

    public int sumTwoNumber(int a, int b) {
        return a + b;
    }

    public int minusTwoNumber(int a, int b) {
        return a - b;
    }

}