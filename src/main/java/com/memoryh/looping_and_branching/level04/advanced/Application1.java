package com.memoryh.looping_and_branching.level04.advanced;

import java.util.Scanner;

/* 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서
 * 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
 *
 * A를 3만큼 밀면 D가 되고, z를 1만큼 밀면 a가 됩니다.
 * 또한 공백문자는 변경되지 않습니다.
 *
 * 문자열 1개를 입력 받고, 얼마나 문자를 밀지 알려주는 0보다 큰 정수를 1개 입력 받아
 * 암호문을 작성하는 프로그램을 만들어보세요
 * 단, 숫자가 27인 경우는 1칸을 밀게 됩니다. (알파벳은 26글자 이기 때문)
 *
 * -- 입력 예시 --
 * 문자열을 입력하세요 : a B z
 * 숫자를 입력하세요 : 4
 *
 * -- 출력 예시 --
 * e F d
 *
 * -- 입력 예시 --
 * 문자열을 입력하세요 : a B z
 * 숫자를 입력하세요 : 27
 *
 * -- 출력 예시 --
 * b C a
 * */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        String inputText = getInputString();
        int shift = getInputNumber();
        System.out.println(encryptString(inputText, shift));
        sc.close();
    }

    private static String encryptString(final String text, final int shift) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            sb.append(encryptCharacter(ch, shift));
        }
        return sb.toString();
    }

    private static char encryptCharacter(final char ch, final int shift) {
        if (Character.isUpperCase(ch)) {
            return (char) ((ch - 'A' + shift) % ALPHABET_SIZE + 'A');
        } else if (Character.isLowerCase(ch)) {
            return (char) ((ch - 'a' + shift) % ALPHABET_SIZE + 'a');
        }
        return ch;
    }

    private static int getInputNumber() {
        System.out.print("숫자를 입력하세요 : ");
        return sc.nextInt();
    }

    private static String getInputString() {
        System.out.print("문자열을 입력하세요 : ");
        return sc.nextLine();
    }

}