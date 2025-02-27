package com.memoryh.collection.level01.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
학생들의 ID를 관리하는 프로그램을 작성하세요. 이미 존재하는 ID는 추가하지 않으며, 전체 학생 ID를 출력합니다.

학생 ID 입력('exit' 입력 시 종료): hello
ID가 추가 되었습니다.
학생 ID 입력('exit' 입력 시 종료): java
ID가 추가 되었습니다.
학생 ID 입력('exit' 입력 시 종료): programmer
ID가 추가 되었습니다.
학생 ID 입력('exit' 입력 시 종료): java
이미 등록 된 ID입니다.
학생 ID 입력('exit' 입력 시 종료): exit
모든 학생의 ID : [java, programmer, hello]
 */
public class Application4 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> registeredStudentIds = new HashSet<>();

        while (true) {
            String inputStudentId = getStudentId();

            if (inputStudentId.equals("exit")) {
                printAllRegisteredStudentIds(registeredStudentIds);
                break;
            }
            if (registeredStudentIds.contains(inputStudentId)) {
                printDuplicateIdWarning();
                continue;
            }
            registeredStudentIds.add(inputStudentId);
            printStudentIdAdded();
        }
    }

    private static void printAllRegisteredStudentIds(final Set<String> studentsId) {
        System.out.println("모든 학생의 ID : " + studentsId);
    }

    private static void printDuplicateIdWarning() {
        System.out.println("이미 등록된 ID입니다.");
    }

    private static void printStudentIdAdded() {
        System.out.println("ID가 추가되었습니다.");
    }

    private static String getStudentId() {
        System.out.print("학생 ID 입력('exit' 입력 시 종료): ");
        return sc.nextLine();
    }

}