package com.memoryh.conditional.level03.hard;

import java.util.Scanner;

/* 두 개의 정수를 입력 받아 변수에 저장하고,
 * 연산기호(+, -, *, /, %)를 입력 받아 해당 연산의 수행 결과를 출력하세요.
 * 단, 준비된 연산기호 외의 문자를 입력하는 경우 "입력하신 연산은 없습니다. 프로그램을 종료합니다." 출력 후 프로그램 종료
 *
 * -- 입력 예시 --
 * 첫 번째 정수 : 4
 * 두 번째 정수 : 3
 * 연산 기호를 입력하세요 : +
 *
 * -- 출력 예시 --
 * 4 + 3 = 7
 */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int firstNumber = getFirstInteger();
        int secondNumber = getSecondInteger();
        String operator = getOperator();
        System.out.println(calculateResult(operator, firstNumber, secondNumber));
        sc.close();
    }

    private static int calculateResult(final String operator, final int firstNumber, final int secondNumber) {
        int result = 0;
        switch (operator) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> result = firstNumber / secondNumber;
            case "%" -> result = firstNumber % secondNumber;
        }
        return result;
    }

    private static String getOperator() {
        System.out.print("연산 기호를 입력하세요 : ");
        return sc.nextLine();
    }

    private static int getSecondInteger() {
        System.out.print("두 번째 정수 : ");
        return readUserInput();
    }

    private static int getFirstInteger() {
        System.out.print("첫 번째 정수 : ");
        return readUserInput();
    }

    private static int readUserInput() {
        return sc.nextInt();
    }

}