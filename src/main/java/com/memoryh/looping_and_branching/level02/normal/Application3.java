package com.memoryh.looping_and_branching.level02.normal;

import java.util.Scanner;

/* 정수를 입력받아 1부터 입력받은 정수까지
 * 홀수이면 "수", 짝수이면 "박"이 정수만큼 누적되어 출력되게 작성하시오.
 *
 * -- 입력 예시 --
 * 정수를 입력하세요 : 5
 *
 * -- 출력 예시 --
 * 수박수박수
 * */
public class Application3 {

    private static final Scanner sc = new Scanner(System.in);

    private static final String EVEN_WORD = "박";
    private static final String ODD_WORD = "수";

    public static void main(String[] args) {
        int inputNumber = getInputNumber();
        printAlternatingSuBakPattern(inputNumber);
        sc.close();
    }

    private static void printAlternatingSuBakPattern(final int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                result.append(EVEN_WORD);
            } else {
                result.append(ODD_WORD);
            }
        }
        System.out.println(result);
    }

    private static int getInputNumber() {
        System.out.print("정수를 입력하세요 : ");
        return sc.nextInt();
    }

}