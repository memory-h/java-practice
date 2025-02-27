package com.memoryh.collection.level01.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
사용자가 입력한 단어들을 사전순으로 정렬한 후 출력하는 프로그램을 작성하세요.

단어 입력 ('exit' 입력 시 종료): 안녕
단어 입력 ('exit' 입력 시 종료): java
단어 입력 ('exit' 입력 시 종료): collection
단어 입력 ('exit' 입력 시 종료): 프로그래밍
단어 입력 ('exit' 입력 시 종료): exit
정렬 된 단어 : [collection, java, 안녕, 프로그래밍]
 */
public class Application5 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();

        while (true) {
            String inputWord = getInputWord();

            if (inputWord.equals("exit")) {
                printSortedWords(wordList);
                break;
            }
            wordList.add(inputWord);
        }
    }

    private static void printSortedWords(final List<String> wordList) {
        sortWords(wordList);
        System.out.println("정렬 된 단어 : " + wordList);
    }

    private static void sortWords(final List<String> wordList) {
        Collections.sort(wordList);
    }

    private static String getInputWord() {
        System.out.print("단어 입력 ('exit' 입력 시 종료): ");
        return sc.nextLine();
    }

}