package com.memoryh.array.level02.normal;

import java.util.Scanner;

/* 주민등록번호를 스캐너로 입력 받고 문자 배열로 저장한 뒤,
 * 성별 자리 이후부터 *로 가려서 출력하세요
 *
 * -- 입력 예시 --
 * 주민등록번호를 입력하세요 : 990101-1234567
 *
 * -- 출력 예시 --
 * 990101-1******
 */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String MASK_CHAR = "*";

    public static void main(String[] args) {
        String residentRegistrationNumber = getResidentRegistrationNumber();
        char[] residentRegistrationArr = residentRegistrationNumber.toCharArray();
        String maskPersonalNumber = maskPersonalNumber(residentRegistrationArr);
        printMaskPersonalNumber(maskPersonalNumber);
        sc.close();
    }

    private static void printMaskPersonalNumber(String maskPersonalNumber) {
        System.out.println(maskPersonalNumber);
    }

    private static String maskPersonalNumber(final char[] residentRegistrationArr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < residentRegistrationArr.length; i++) {
            if (i < 8) {
                sb.append(residentRegistrationArr[i]);
            } else {
                sb.append(MASK_CHAR);
            }
        }
        return sb.toString();
    }

    private static String getResidentRegistrationNumber() {
        System.out.print("주민등록번호를 입력하세요 : ");
        return sc.nextLine();
    }

}