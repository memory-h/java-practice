package com.memoryh.looping_and_branching.level03.hard;

import java.util.Scanner;
import java.util.stream.IntStream;

/* 문자열을 하나 입력 받고, 검색할 문자를 입력 하여
 * 입력받은 문자열에서 검색할 문자가 몇 개 포함되어 있는지를 출력하는 프로그램을 만드세요
 *
 * 단, 문자열에 영문자가 아닌 문자가 섞여 있는 경우에는
 * 검색할 문자를 입력받지 않고 "영문자가 아닌 문자가 포함되어 있습니다." 출력 후 프로그램을 종료하세요
 *
 * 또한 일치하는 문자의 경우 대소문자를 구분합니다.
 *
 * -- 프로그램 예시 --
 *
 * -- 정상 동작의 경우 --
 * -- 입력 예시 --
 * 문자열 입력 : apple
 * 문자 입력 : p
 *
 * -- 출력 예시 --
 * 포함된 갯수 : 2개
 *
 * --------------------
 * -- 영문자가 아닌 문자 포함된 경우 --
 * -- 입력 예시 --
 * 문자열 입력 : app2le
 *
 * -- 출력 예시 --
 * 영문자가 아닌 문자가 포함되어 있습니다.
 * */
public class Application3 {

    private static final Scanner sc = new  Scanner(System.in);

    private static final String ALPHABET_ONLY_REGEX = "^[a-zA-Z]*$";
    private static final int START_INDEX = 0;
    private static final int FIRST_CHAR_INDEX = 0;

    public static void main(String[] args) {
        try {
            String eng = getEnglishString();
            char alpha = getAlphabet();
            int charCount = (int) IntStream.range(START_INDEX, eng.length())
                    .filter(i -> eng.charAt(i) == alpha)
                    .count();
            printCharacterCount(charCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void printCharacterCount(int charCount) {
        System.out.println("\n포함된 갯수 : " + charCount + "개");
    }

    private static Character getAlphabet() {
        System.out.print("문자 입력 : ");
        return readUserInput().charAt(FIRST_CHAR_INDEX);
    }

    private static String getEnglishString() {
        System.out.print("문자열 입력 : ");
        return readUserInput();
    }

    private static String validateUserInput(String userInput) {
        if (!userInput.matches(ALPHABET_ONLY_REGEX)) {
            throw new IllegalArgumentException("영문자가 아닌 문자가 포함되어 있습니다.");
        }
        return userInput;
    }

    private static String readUserInput() {
        return validateUserInput(sc.nextLine());
    }

}