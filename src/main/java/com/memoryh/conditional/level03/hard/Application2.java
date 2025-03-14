package com.memoryh.conditional.level03.hard;

import java.util.*;

/* 과일 이름("사과", "바나나", "복숭아", "키위") 중 한 가지를 문자열로 입력하면
 * 해당하는 가격에 맞게 상품명과 가격이 출력되게 하세요.
 * 단, 목록에 없는 과일을 입력 시 "준비된 상품이 없습니다." 출력 후 프로그램 종료
 *
 * -- 상품 가격 --
 * 사과 :  1000원
 * 바나나 : 3000원
 * 복숭아 : 2000원
 * 키위 : 5000원
 *
 * -- 입력 예시 --
 * 과일 이름을 입력하세요 : 바나나
 *
 * -- 출력 예시 --
 * 바나나의 가격은 3000원 입니다.
 * */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Integer> fruits = getFruitPriceMap();
        String fruitName = getFruitName();
        if (fruits.containsKey(fruitName)) {
            System.out.println(fruitName + "의 가격은 " +  fruits.get(fruitName) + "원 입니다.");
        }
        sc.close();
    }

    private static String getFruitName(){
        System.out.print("과일 이름을 입력하세요 : ");
        return sc.nextLine();
    }

    private static Map<String, Integer> getFruitPriceMap() {
        return Map.of(
                "사과", 1000,
                "바나나", 3000,
                "복숭아", 2000,
                "키위", 5000);
    }

}