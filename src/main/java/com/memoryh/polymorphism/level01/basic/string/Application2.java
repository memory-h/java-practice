package com.memoryh.polymorphism.level01.basic.string;

import java.util.*;

/* ----- 입력 예시 -----
 *
 * 문자열 입력 : hello world Hello everyone! 안녕하세요 반갑습니다
 *
 * ----- 출력 예시 -----
 *
 * ===== 단어 빈도 =====
 * hello: 2
 * world: 1
 * everyone: 1
 * 가장 빈도 높은 단어 : hello (2 번)
 */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String userInput = readUserInput();
        Map<String, Integer> wordFrequency = calculateWordFrequency(userInput);
        String mostFrequentWord = findMostFrequentWord(wordFrequency);
        printWordCountAndMaxWordCount(wordFrequency, mostFrequentWord);
    }

    private static void printWordCountAndMaxWordCount(final Map<String, Integer> map, final String mostFrequentWord) {
        StringBuilder sb = new StringBuilder("===== 단어 빈도 =====\n");
        int maxCount = map.getOrDefault(mostFrequentWord, 0);

        for (String word : map.keySet()) {
            sb.append(word)
                    .append(": ")
                    .append(map.get(word))
                    .append("\n");
        }
        sb.append("가장 빈도 높은 단어: ")
                .append(mostFrequentWord)
                .append(" (").append(maxCount)
                .append(" 번)");

        System.out.println(sb);
    }

    private static String findMostFrequentWord(final Map<String, Integer> map) {
        String maxWord = "";
        int maxCount = 0;

        for (String word : map.keySet()) {
            if (map.get(word) > maxCount) {
                maxCount = map.get(word);
                maxWord = word;
            }
        }
        return maxWord;
    }

    private static Map<String, Integer> calculateWordFrequency(final String userInput) {
        Map<String, Integer> map = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(userInput);

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    private static String validateUserInput(final String userInput) {
        StringBuilder validUserInput = new StringBuilder();

        for (char c : userInput.toCharArray()) {
            if (Character.isLowerCase(c)) {
                validUserInput.append(c);
            } else if (c == ' ') {
                validUserInput.append(" ");
            }
        }
        return validUserInput.toString();
    }

    private static String readUserInput() {
        System.out.print("문자열 입력 : ");
        return validateUserInput(sc.nextLine().toLowerCase());
    }

}