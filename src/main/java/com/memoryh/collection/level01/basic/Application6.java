package com.memoryh.collection.level01.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
이름을 입력하면 전화번호를 검색할 수 있도록 전화번호부를 구현하세요.

이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 홍길동010-1234-5678
입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>
이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 홍길동 010-1234-5678
추가 완료 : 홍길동 010-1234-5678
이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 유관순 010-9876-5432
추가 완료 : 유관순 010-9876-5432
이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): search
검색 할 이름 : 유관순
유관순씨의 전화번호 : 010-9876-5432
이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): search
검색 할 이름 : 이순신
이순신씨의 번호는 등록 되어 있지 않습니다.
이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): exit
 */
public class Application6 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String USERNAME_PHONE_NUMBER_DELIMITER = " ";
    private static final String USERNAME_AND_PHONE_NUMBER_REGEX = "^\\S+\\s\\d{3}-\\d{4}-\\d{4}$";

    public static void main(String[] args) {
        Map<String, String> memberInfoMap = new HashMap<>();

        while (true) {
            String nameAndPhoneNumber = getNameAndPhoneNumber();

            if (nameAndPhoneNumber.equals("exit")) {
                break;
            }

            if (nameAndPhoneNumber.equals("search")) {
                String inputUserName = getUserName();
                boolean findUserInfo = isFindUserInfo(memberInfoMap, inputUserName);
                printUserInfoSearchResult(findUserInfo, inputUserName, memberInfoMap);
                continue;
            }

            try {
                validateNotBlank(nameAndPhoneNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            addMemberNameAndPhoneNumber(nameAndPhoneNumber, memberInfoMap);
        }
    }

    private static boolean isFindUserInfo(final Map<String, String> memberInfoMap, final String inputUserName) {
        for (String name : memberInfoMap.keySet()) {
            if (name.equals(inputUserName)) {
                return true;
            }
        }
        return false;
    }

    private static void printUserInfoSearchResult(final boolean findUserInfo, final String inputUserName, final Map<String, String> memberInfoMap) {
        if (findUserInfo) {
            System.out.println(inputUserName + "씨의 전화번호 : " + memberInfoMap.get(inputUserName));
        } else {
            System.out.println(inputUserName + "씨의 번호는 등록 되어 있지 않습니다.");
        }
    }

    private static String getUserName() {
        System.out.print("검색 할 이름 : ");
        return getUserInput();
    }

    private static void printUserInfoAdded(final String userName, final String phoneNumber) {
        System.out.println("추가 완료 : " + userName + " " +  phoneNumber);
    }

    private static void addMemberNameAndPhoneNumber(final String nameAndPhoneNumber, final Map<String, String> memberInfoMap) {
        String[] splitNameAndPhoneNumber = nameAndPhoneNumber.split(USERNAME_PHONE_NUMBER_DELIMITER);
        String userName = splitNameAndPhoneNumber[0];
        String phoneNumber = splitNameAndPhoneNumber[1];

        memberInfoMap.put(userName, phoneNumber);
        printUserInfoAdded(userName, phoneNumber);
    }

    private static void validateNotBlank(final String nameAndPhoneNumber) {
        if (!nameAndPhoneNumber.matches(USERNAME_AND_PHONE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>");
        }
    }

    private static String getNameAndPhoneNumber() {
        System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): ");
        return getUserInput();
    }

    private static String getUserInput() {
        return sc.nextLine();
    }

}