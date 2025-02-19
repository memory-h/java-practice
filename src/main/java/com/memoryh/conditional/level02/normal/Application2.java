package com.memoryh.conditional.level02.normal;

import java.util.Scanner;

/* BMI(신체질량지수)를 계산하고, 계산된 값에 따라
 * 저체중(20 미만)인 경우 "당신은 저체중 입니다.",
 * 정상체중(20이상 25미만)인 경우 "당신은 정상체중 입니다.",
 * 과제충(25이상 30미만)인 경우 "당신은 과체중 입니다.",
 * 비만(30이상)인 경우 "당신은 비만 입니다." 를 출력하세요
 *
 * BMI 계산 방법은 체중(kg) / (신장(m) * 신장(m)) 이다.
 *
 * 계산 예시) BMI = 67 / (1.7 * 1.7)
 * */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);

    private static final double OBESITY_THRESHOLD = 30.0;   // 비만 기준
    private static final double OVERWEIGHT_THRESHOLD = 25.0; // 과체중 기준
    private static final double NORMAL_THRESHOLD = 20.0;    // 정상 체중 기준

    public static void main(String[] args) {
        int kg = getWeight();
        double m = getHeight();
        double bmi = getBmi(kg, m);
        printBMIResult(bmi);
        sc.close();
    }

    private static void printBMIResult(final double bmi) {
        if (bmi >= OBESITY_THRESHOLD) {
            System.out.println("당신은 비만 입니다.");
        } else if (bmi >= OVERWEIGHT_THRESHOLD) {
            System.out.println("당신은 과체중 입니다.");
        } else if (bmi >= NORMAL_THRESHOLD) {
            System.out.println("당신은 정상체중 입니다.");
        } else {
            System.out.println("당신은 저체중 입니다.");
        }
    }

    private static double getBmi(final int kg, final double m) {
        return kg / m * m;
    }

    private static double getHeight() {
        System.out.print("신장을 입력하세요.(예: 170cm는 1.7) : ");
        return sc.nextDouble();
    }

    private static int getWeight() {
        System.out.print("체중을 입력하세요. : ");
        return sc.nextInt();
    }

}