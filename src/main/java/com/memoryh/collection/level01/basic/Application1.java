package com.memoryh.collection.level01.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
학생 성적 : 100
추가 입력하려면 y : y
학생 성적 : 95
추가 입력하려면 y : Y
학생 성적 : 66
추가 입력하려면 y : y
학생 성적 : 79
추가 입력하려면 y : n
학생 인원 : 4
평균 점수 : 85.0
 */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Double> grades = new ArrayList<>();

        while (true) {
            grades.add(getStudentGrade());
            if (isAdditionalInputRequired().equals("n")) {
                break;
            }
        }

        int studentCount = getStudentCount(grades);
        double avgStudentGrade = getAvgStudentGrade(grades, studentCount);

        printStudentCountAndAvgStudentGrade(studentCount, avgStudentGrade);
    }

    private static void printStudentCountAndAvgStudentGrade(final int studentCount, final double avgStudentGrade) {
        System.out.println("학생 인원 : " + studentCount);
        System.out.println("평균 점수 : " + avgStudentGrade);
    }

    private static double getAvgStudentGrade(final List<Double> grades, final int studentCount) {
        double sumScore = grades.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        return sumScore / studentCount;
    }

    private static int getStudentCount(final List<Double> grades) {
        return grades.size();
    }

    private static String isAdditionalInputRequired() {
        System.out.print("추가 입력하려면 y : ");
        return readUserInput().toLowerCase();
    }

    private static double parseDouble(final String userInput){
        return Double.parseDouble(userInput);
    }

    private static double getStudentGrade() {
        System.out.print("학생 성적 : ");
        String userInput = readUserInput();
        return parseDouble(userInput);
    }

    private static String readUserInput() {
        return sc.nextLine();
    }

}