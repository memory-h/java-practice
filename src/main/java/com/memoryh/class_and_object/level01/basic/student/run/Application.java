package com.memoryh.class_and_object.level01.basic.student.run;

import com.memoryh.class_and_object.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

/*
최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
while문을 사용하여 학생들의 정보를 계속 입력 받고
한 명씩 추가 될 때마다 카운트함
계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
3명 정도의 학생 정보를 입력 받아 각 객체에 저장함
현재 기록된 학생들의 각각의 점수 평균을 구함
학생들의 정보를 모두 출력 (평균 포함)
 */
public class Application {

    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX_STUDENTS_INFO_STORAGE = 10;

    private static int currentStudentCount = 0;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        StudentDTO[] students = new StudentDTO[MAX_STUDENTS_INFO_STORAGE];

        while (currentStudentCount < MAX_STUDENTS_INFO_STORAGE) {
            students[currentStudentCount++] = getStudentInformation();
            String yesOrNo = getYesOrNo();

            if (yesOrNo.equals("n")) {
                break;
            }
        }

        printAllStudentsInformation(students);
    }

    private static void printStudentInformation(final String studentsInformation, final int scoreAverage) {
        System.out.println(studentsInformation + ", 평균=" + scoreAverage);
    }

    private static int getScoreAverage(final int kor, final int eng, final int math) {
        return (kor + eng + math) / 3;
    }

    private static void printAllStudentsInformation(final StudentDTO[] students) {
        if (currentStudentCount == MAX_STUDENTS_INFO_STORAGE) {
            System.out.println("10명의 학생 정보가 입력되어 종료됩니다.");
        }

        for (StudentDTO student : students) {
            if (student == null) {
                break;
            }
            int scoreAverage = getScoreAverage(student.getKor(), student.getEng(), student.getMath());
            printStudentInformation(student.getInformation(), scoreAverage);
        }
    }

    private static String getYesOrNo() {
        System.out.print("계속 추가할 겁니까? (y/n) : ");
        return sc.next().toLowerCase();
    }

    private static StudentDTO getStudentInformation() {
        int grade = getGrade();
        int classroom = getClassroom();
        String studentName = getStudentName();
        int kor = getKorScore();
        int eng = getEngScore();
        int math = getMathScore();

        return new StudentDTO(grade, classroom, studentName, kor, eng, math);
    }

    private static int getMathScore() {
        System.out.print("수학점수 : ");
        return sc.nextInt();
    }

    private static int getEngScore() {
        System.out.print("영어점수 : ");
        return sc.nextInt();
    }

    private static int getKorScore() {
        System.out.print("국어점수 : ");
        return sc.nextInt();
    }

    private static String getStudentName() {
        System.out.print("이름 : ");
        return sc.next();
    }

    private static int getClassroom() {
        System.out.print("반 : ");
        return sc.nextInt();
    }

    private static int getGrade() {
        System.out.print("학년 : ");
        return sc.nextInt();
    }

}