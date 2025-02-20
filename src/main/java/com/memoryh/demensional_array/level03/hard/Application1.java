package com.memoryh.demensional_array.level03.hard;

import java.util.*;

/* 가로와 세로 길이를 정수형으로 입력 받아
 * 입력받은 가로 세로 길이를 이용하여 이차원 배열을 할당하고
 * 각 인덱스에는 랜덤으로 알파벳 대문자 넣어서 출력
 *
 * 단, 가로 행 혹은 세로 열은 반드시 1~10 까지의 정수를 입력해야 하고
 * 그렇지 않은 경우에는 "반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요." 출력 후
 * 가로 행 또는 세로 열을 다시 입력받을 수 있도록 한다.
 *
 * -- 입력 예시 --
 * 가로 행의 수를 입력하세요 : 5
 * 세로 열의 수를 입력하세요 : 4
 *
 * -- 출력 예시 --
 * F H Z G
 * W F O T
 * O R X V
 * W H J X
 * W S S J
 * */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        int rowNumber = getRowNumber();
        int columnNumber = getColumnNumber();
        char[][] arr = new char[rowNumber][columnNumber];

        fillArrayWithRandomAlphabets(arr);
        printArray(arr);
        sc.close();
    }

    private static void fillArrayWithRandomAlphabets(final char[][] arr) {
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ALPHABET.charAt(random.nextInt(ALPHABET.length()));
            }
        }
    }

    private static void printArray(final char[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (char[] row : arr) {
            for (char ch : row) {
                sb.append(ch).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int getColumnNumber() {
        System.out.print("세로 열의 수를 입력하세요 : ");
        try {
            return readUserInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getColumnNumber();
        }
    }

    private static int getRowNumber() {
        System.out.print("가로 행의 수를 입력하세요 : ");
        try {
            return readUserInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRowNumber();
        }
    }

    private static void validateUserInput(final int userInput) {
        if (userInput < 1 || userInput > 10) {
            throw new IllegalArgumentException("반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요.");
        }
    }

    private static int readUserInput() {
        int userInput = sc.nextInt();
        validateUserInput(userInput);
        return userInput;
    }

}