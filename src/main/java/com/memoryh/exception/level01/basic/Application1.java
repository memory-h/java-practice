package com.memoryh.exception.level01.basic;

import java.util.Scanner;

/* ----- 입력 예시 -----
 *
 * 분자 입력 : 10
 * 분모 입력 : 2
 *
 * ----- 출력 예시 -----
 *
 * 결과 : 5
 * 실행이 완료되었습니다.
 *
 * ----- 입력 예시 -----
 *
 * 분자 입력 : 십
 *
 * ----- 출력 예시 -----
 *
 * 오류 : 유효한 정수를 입력하세요.
 * 실행이 완료되었습니다.
 *
 * ----- 입력 예시 -----
 *
 * 분자 입력 : 10
 * 분모 입력 : 0
 *
 * ----- 출력 예시 -----
 *
 * 오류 : 0으로 나누는 것은 허용되지 않습니다.
 * 실행이 완료되었습니다.
 */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numerator, denominator;

        try {
            numerator = getNumerator();
            denominator = getDenominator();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            printSuccessMessage();
            return;
        }
        printDivisionResult(numerator, denominator);
        sc.close();
    }

    private static void printSuccessMessage() {
        System.out.println("실행이 완료되었습니다.");
    }

    private static void printDivisionResult(final int numerator, final int denominator) {
        System.out.println("결과 : " + (numerator / denominator));
        printSuccessMessage();
    }

    private static void validateDenominator(final int denominator) {
        final int DENOMINATOR_ZERO = 0;
        if (denominator == DENOMINATOR_ZERO) {
            throw new IllegalArgumentException("오류 : 0으로 나누는 것은 허용되지 않습니다.");
        }
    }

    private static int pareInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    private static int getDenominator() {
        System.out.print("분모 입력 : ");
        String userInput = readUserInput();
        int parseUserInput = pareInt(userInput);
        validateDenominator(parseUserInput);
        return parseUserInput;
    }

    private static int getNumerator() {
        System.out.print("분자 입력 : ");
        String userInput = readUserInput();
        return pareInt(userInput);
    }

    private static void validateUserInput(final String userInput) {
        final String USER_INPUT_REGEX = "^-?\\d+$";
        if (!userInput.matches(USER_INPUT_REGEX)) {
            throw new IllegalArgumentException("오류 : 유효한 정수를 입력하세요.");
        }
    }

    private static String readUserInput() {
        String userInput = sc.nextLine();
        validateUserInput(userInput);
        return userInput;
    }

}