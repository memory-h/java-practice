package com.memoryh.looping_and_branching.level02.normal;

import java.util.Scanner;

/* 문자열을 입력 받아서 문자열의 각 인덱스별로 한 글자씩 출력하세요
 *
 * 참고) 문자열의 길이는 String 클래스의 length() 메소드를 이용할 수 있습니다.
 *
 * -- 입력 예시 --
 * 문자열을 입력하세요 : apple
 *
 * -- 출력 예시 --
 * 0 : a
 * 1 : p
 * 2 : p
 * 3 : l
 * 4 : e
 * */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = getUserStringInput();
        printCharAndIndex(str);
        sc.close();
    }

    private static void printCharAndIndex(final String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(i)
                    .append(" : ")
                    .append(str.charAt(i))
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static String getUserStringInput() {
        System.out.print("문자열을 입력하세요. : ");
        return sc.nextLine();
    }

}