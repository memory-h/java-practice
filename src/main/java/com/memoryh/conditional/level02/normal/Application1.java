package com.memoryh.conditional.level02.normal;

import java.util.Scanner;

/* 1~10 사이의 정수 한개를 입력받아 홀수인지 짝수인지 인지 확인하고,
 * 홀수이면 "홀수다.", 홀수가 아니면 "짝수다." 라고 출력하세요.
 * 단, 1~10 사이의 정수가 아닌 경우 "반드시 1~10 사이의 정수를 입력해야 합니다." 를 출력하세요.
 * */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    private static final int MIN_INTEGER_VALUE = 1;
    private static final int MAX_INTEGER_VALUE = 10;

    public static void main(String[] args) {
        int number = sc.nextInt();
        printEvenOrOdd(number);
        sc.close();
    }

    private static void printEvenOrOdd(final int number) {
        if (number < MIN_INTEGER_VALUE || number > MAX_INTEGER_VALUE) {
            System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
        } else {
            System.out.println(number % 2 == 0 ? "짝수다." : "홀수다.");
        }
    }

}