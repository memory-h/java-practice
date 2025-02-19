package com.memoryh.looping_and_branching.level03.hard;

import java.util.Scanner;

/* 2보다 큰 정수를 하나 입력 받아 그 수가 소수인지 아닌지를 판별해서 출력하세요
 * 소수인 경우 "소수다." 출력, 소수가 아닌 경우 "소수가 아니다." 출력
 *
 * 단, 2보다 큰 정수가 아닌 경우 "잘못 입력하셨습니다. 다시 입력하세요." 라고 출력 후
 * 정수를 다시 입력 받을 수 있도록 한다.
 *
 * 소수란?
 * 어떤 수를 1부터 자기 자신까지 차례대로 나누었을 때
 * 나누어 떨어지는 수가 1과 자기 자신만 존재하는 수를 소수라고 한다.
 *
 * -- 입력 예시 --
 * 2보다 큰 정수를 하나 입력하세요 : 7
 *
 * -- 출력 예시 --
 * 소수다.
 * */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    private static final int MINIMUM_VALID_NUMBER = 2;
    private static final int DIVISIBLE_REMAINDER = 0;

    public static void main(String[] args) {
        printNumberInputMessage();
        findPrimeNumber(readUserInput());
        sc.close();
    }

    private static void findPrimeNumber(final int number) {
        if (isPrimeNumber(number)) {
            System.out.println("소수다.");
        } else {
            printInvalidInputMessage();
        }
    }

    private static boolean isPrimeNumber(final int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == DIVISIBLE_REMAINDER) {
                return false;
            }
        }
        return true;
    }

    private static void printInvalidInputMessage() {
        System.out.print("소수가 아니다.");
    }

    private static void printNumberInputMessage() {
        System.out.print("2보다 큰 정수를 하나 입력하세요. : ");
    }

    private static int validateUserInput(final int number) {
        if (number <= MINIMUM_VALID_NUMBER) {
            System.out.print("잘못 입력하셨습니다. 다시 입력하세요. : ");
            return readUserInput();
        }
        return number;
    }

    private static int readUserInput() {
        return validateUserInput(sc.nextInt());
    }

}