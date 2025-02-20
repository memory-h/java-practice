package com.memoryh.array.level03.hard;

import java.util.Scanner;

/* 홀수인 양의 정수를 입력 받아 입력 받은 크기 만큼의 정수형 배열을 할당하고
 * 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
 * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값 넣어 출력하세요
 *
 * 단, 홀수인 양의 정수를 입력하지 않은 경우에는 "양수 혹은 홀수만 입력해야 합니다."를 출력하세요
 *
 * -- 입력 예시 --
 * 홀수인 양의 정수를 입력하세요 : 7
 *
 * -- 출력 예시 --
 * 1 2 3 4 3 2 1
 *
 * -- 입력 예시 --
 * 홀수인 양의 정수를 입력하세요 : 8
 *
 * -- 출력 예시 --
 * 양수 혹은 홀수만 입력해야 합니다.
 */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int positiveOdd = getPositiveOdd();
        int[] oddArray = generateSymmetricArray(positiveOdd);
        printArray(oddArray);
        sc.close();
    }

    private static void printArray(final int[] oddArray) {
        StringBuilder sb = new StringBuilder();

        for (int val : oddArray) {
            sb.append(val)
                    .append(" ");
        }
        System.out.println(sb);
    }

    private static int[] generateSymmetricArray(final int positiveOdd) {
        int[] oddArray = new int[positiveOdd];
        oddArray[0] = 1;

        for (int i = 1; i <= positiveOdd / 2; i++) {
            oddArray[i] = oddArray[i - 1] + 1;
        }
        for (int i = positiveOdd / 2 + 1; i < positiveOdd; i++) {
            oddArray[i] = oddArray[i - 1] - 1;
        }
        return oddArray;
    }

    private static void validatePositiveOdd(final int userInput) {
        if (userInput <= 0 || userInput % 2 == 0) {
            throw new IllegalArgumentException("양수 혹은 홀수만 입력해야 합니다.");
        }
    }

    private static int getPositiveOdd() {
        try {
            System.out.print("홀수인 양의 정수를 입력하세요 : ");
            int userInput = sc.nextInt();
            validatePositiveOdd(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPositiveOdd();
        }
    }

}