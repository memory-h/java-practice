package com.memoryh.exception.level01.basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/* ----- 입력 예시 -----
 *
 * 생년월일 입력 (yyyy-MM-dd 양식으로 작성) : 2014-05-05
 *
 * ----- 출력 예시 -----
 *
 * 만 20세 미만은 입장 불가입니다.
 *
 * ----- 입력 예시 -----
 *
 * 생년월일 입력 (yyyy-MM-dd 양식으로 작성) : 1994-05-05
 *
 * ----- 출력 예시 -----
 *
 * 입장하셔도 됩니다.
 *
 * ----- 입력 예시 -----
 *
 * 생년월일 입력 (yyyy-MM-dd 양식으로 작성) : 2000-14-15
 *
 * ----- 출력 예시 -----
 *
 * 날짜 양식을 잘못 입력하셨습니다.
 */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String dateOfBirth = getDateOfBirth();
        LocalDate parseDateOfBirth;

        try {
            parseDateOfBirth = parseDateOfBirth(dateOfBirth);
        } catch (DateTimeParseException e) {
            System.out.println("날짜 형식을 잘못 입력하셨습니다.");
            return;
        }
        processEntryPermission(parseDateOfBirth);
        sc.close();
    }

    private static void processEntryPermission(final LocalDate parseDateOfBirth) {
        try {
            if (checkEntryPermission(parseDateOfBirth)) {
                System.out.println("입장하셔도 됩니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean checkEntryPermission(final LocalDate parseDateOfBirth) {
        int curYear = LocalDate.now().getYear();
        int userYear = parseDateOfBirth.getYear();

        if (curYear - userYear < 20) {
            throw new IllegalArgumentException("만 20세 미만은 입장 불가입니다.");
        }
        return true;
    }

    private static LocalDate parseDateOfBirth(final String dateOfBirth) {
        return LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private static String getDateOfBirth() {
        System.out.print("생년월일 입력 (yyyy-MM-dd 양식으로 작성) : ");
        return sc.nextLine();
    }

}