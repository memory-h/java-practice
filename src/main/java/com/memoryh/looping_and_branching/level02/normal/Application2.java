package com.memoryh.looping_and_branching.level02.normal;

/* 반복문을 이용하여 알파벳 소문자 'a'부터 'z'까지를 개행 없이 차례로 출력하세요
 *
 * -- 출력 예시 --
 * abcdefghijklmnopqrstuvwxyz
 * */
public class Application2 {

    public static void main(String[] args) {
        printAlphabet();
    }

    private static void printAlphabet() {
        StringBuilder sb = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            sb.append(c);
        }
        System.out.println(sb);
    }

}