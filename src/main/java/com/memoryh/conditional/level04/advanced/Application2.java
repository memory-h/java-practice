package com.memoryh.conditional.level04.advanced;

import java.util.Scanner;

/* 영업사원의 월급을 계산하는 프로그램을 작성하려고 합니다.
 * 월 급여액과 월 매출액을 입력 받아 급여를 산정합니다.
 * 영업사원은 매출액 대비 보너스율에 명시된 보너스를 급여 외에 추가로 지급받습니다.
 *
 * 단, 보너스율은 입력 받은 월 매출액에 비례하며,
 * 계산된 보너스 금액을 월 급여액에 더하여 총 급여를 계산한다.
 *
 * 보너스율을 적용하여 출력 예시처럼 출력되도록 프로그램을 만들어보세요
 *
 * -- 총 급여 계산식 --
 * 총 급여 = 월 급여  + (매출액 * 보너스율)
 *
 * -- 매출액 대비 보너스율 --
 *   매출액       보너스율
 * 5천만원 이상      5%
 * 3천만원 이상      3%
 * 1천만원 이상      1%
 * 1천만원 미만      0%
 *
 * -- 입력 예시 --
 * 월 급여 입력 : 3000000
 * 매출액 입력 : 20000000
 *
 * -- 출력 예시 --
 * ======================
 * 매출액 : 20000000
 * 보너스율 : 1%
 * 월 급여 : 3000000
 * 보너스 금액 : 200000
 * ======================
 * 총 급여 : 3200000
 * */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);

    private static final double BONUS_CONVERSION_FACTOR = 0.01; // 보너스율을 소수점으로 변환
    private static final int REVENUE_THRESHOLD_HIGH = 50000000; // 5천만원 이상
    private static final int REVENUE_THRESHOLD_MEDIUM = 30000000; // 3천만원 이상
    private static final int REVENUE_THRESHOLD_LOW = 10000000;    // 1천만원 이상
    private static final int BONUS_PERCENTAGE_HIGH = 5;   // 5천만원 이상일 때 5%
    private static final int BONUS_PERCENTAGE_MEDIUM = 3; // 3천만원 이상일 때 3%
    private static final int BONUS_PERCENTAGE_LOW = 1;    // 1천만원 이상일 때 1%
    private static final int BONUS_PERCENTAGE_NONE = 0;   // 1천만원 미만일 때 0%

    public static void main(String[] args) {
        int salary = getSalary();
        int revenue = getRevenue();
        int salesBonusRate = getSalesBonusRate(revenue);
        int bonusSalary = (int) (revenue * (salesBonusRate * BONUS_CONVERSION_FACTOR));
        int totalSalary = salary + bonusSalary; // 총 급여
        printSalaryCalculate(revenue, salesBonusRate, salary, bonusSalary, totalSalary);
        sc.close();
    }

    private static void printSalaryCalculate(
            final int revenue,
            final int bonusRate,
            final int salary,
            final int bonusSalary,
            final int totalSalary
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n======================").append("\n")
                .append("매출액 : ").append(revenue).append("\n")
                .append("보너스 비율 : ").append(bonusRate).append("%").append("\n")
                .append("월 급여 :  ").append(salary).append("\n")
                .append("보너스 금액 :  ").append(bonusSalary).append("\n")
                .append("======================").append("\n")
                .append("총 급여 : ").append(totalSalary);
        System.out.println(sb);
    }

    private static int getSalesBonusRate(final int revenue) {
        if (revenue >= REVENUE_THRESHOLD_HIGH) {
            return BONUS_PERCENTAGE_HIGH;
        } else if (revenue >= REVENUE_THRESHOLD_MEDIUM) {
            return BONUS_PERCENTAGE_MEDIUM;
        } else if (revenue >= REVENUE_THRESHOLD_LOW) {
            return BONUS_PERCENTAGE_LOW;
        } else {
            return BONUS_PERCENTAGE_NONE;
        }
    }

    private static int getRevenue() {
        System.out.print("매출액 입력 : ");
        return readUserInput();
    }

    private static int getSalary() {
        System.out.print("월 급여 입력 : ");
        return readUserInput();
    }

    private static int readUserInput() {
        return sc.nextInt();
    }

}
/*
3000000
20000000
 */