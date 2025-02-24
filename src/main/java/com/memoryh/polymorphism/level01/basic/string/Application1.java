package com.memoryh.polymorphism.level01.basic.string;

import java.util.Scanner;
import java.util.StringTokenizer;

/* ----- 입력 예시 -----
 *
 * 문자열 입력 : I will be a good developer.
 *
 * ----- 출력 예시 -----
 *
 * 변환된 문자열: I Will Be A Good Developer.
 * 총 단어 개수: 6
 */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String userInput = readUserInput();
        String formattedText = convertToTitleCase(userInput);
        int wordCount = getWordCount(userInput);
        printFormattedText(formattedText, wordCount);
    }

    private static void printFormattedText(final String changeUserInput, final int totalWordCount) {
        System.out.println("변환된 문자열: " + changeUserInput);
        System.out.println("총 단어 개수: " + totalWordCount);
    }

    private static String convertToTitleCase(final String userInput) {
        StringTokenizer st = new StringTokenizer(userInput);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            sb.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1))
                    .append(" ");
        }
        return sb.toString();
    }

    private static int getWordCount(final String input) {
        return new StringTokenizer(input).countTokens();
    }

    private static String readUserInput() {
        System.out.print("문자열 입력 : ");
        return sc.nextLine();
    }

}