package com.memoryh.conditional.level04.advanced;

import java.util.Scanner;

/* 국어, 영어, 수학 점수를 입력받아
 * 평균 점수가 60점 이상이면서 각 과목이 40점 이상인 조건이 만족하면 "합격입니다!" 를 출력하세요,
 * 단, 합격이 아닌 경우 불합격 사유가 무엇인지를 모두 출력해주어야 합니다.
 * 평균점수 미달인 경우 "평균점수 미달로 불합격입니다." 라고 출력하고,
 * 과목당 과락 점수가 있는 경우 "xx 과목의 점수 미달로 불합격 입니다." 출력하세요
 *
 * -- 입력 예시 --
 * 국어 점수를 입력하세요 : 60
 * 영어 점수를 입력하세요 : 30
 * 수학 점수를 입력하세요 : 20
 *
 * -- 출력 예시 --
 * 평균 점수 미달로 불합격입니다.
 * 영어 점수 미달로 불합격입니다.
 * 수학 점수 미달로 불합격입니다.
 * */
public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    private static final int PASSING_AVERAGE_SCORE = 60; // 합격 기준 평균 점수
    private static final int MINIMUM_SUBJECT_SCORE = 40; // 과목별 최소 점수 기준
    private static final int NUMBER_OF_SUBJECTS = 3; // 과목 수

    public static void main(String[] args) {
        int kor = getKorScore();
        int eng = getEngScore();
        int math = getMathScore();
        int scoreAvg = getScoreAvg(kor, eng, math);
        printScoreResult(kor, eng, math, scoreAvg);
        sc.close();
    }

    private static void printScoreResult(final int kor, final int eng, final int math, final int scoreAvg) {
        System.out.println();

        if (scoreAvg < PASSING_AVERAGE_SCORE) {
            System.out.println("평균점수 미달로 불합격입니다.");
        }
        if (kor < MINIMUM_SUBJECT_SCORE) {
            System.out.println("국어 점수 미달로 불합격입니다.");
        }
        if (eng < MINIMUM_SUBJECT_SCORE) {
            System.out.println("영어 점수 미달로 불합격입니다.");
        }
        if (math < MINIMUM_SUBJECT_SCORE) {
            System.out.println("수학 점수 미달로 불합격입니다.");
        }
        if (scoreAvg >= PASSING_AVERAGE_SCORE && kor >= MINIMUM_SUBJECT_SCORE &&
                eng >= MINIMUM_SUBJECT_SCORE && math >= MINIMUM_SUBJECT_SCORE) {
            System.out.println("합격입니다!");
        }
    }

    private static int getScoreAvg(final int kor, final int eng, final int math) {
        return (kor + eng + math) / NUMBER_OF_SUBJECTS;
    }

    private static int getMathScore() {
        System.out.print("수학 점수를 입력하세요 : ");
        return readUserInput();
    }

    private static int getEngScore() {
        System.out.print("영어 점수를 입력하세요 : ");
        return readUserInput();
    }

    private static int getKorScore() {
        System.out.print("국어 점수를 입력하세요 : ");
        return readUserInput();
    }

    private static int readUserInput() {
        return sc.nextInt();
    }

}