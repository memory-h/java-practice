package com.memoryh.generic.level01.basic;

public class Application2 {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Integer 합계 : " + sum(intArray));

        Double[] doubleArray = {1.1, 2.2, 3.3};
        System.out.println("Double 합계 : " + sum(doubleArray));

        String[] strArray = {"A", "B", "C"};
//        System.out.println("String 합계 : " + sum(strArray));  // 컴파일 에러 발생
    }

    private static <T extends Number> Number sum(final T[] numberArray) {
        boolean hasFloatingPoint = false;
        double sum = 0;

        for (T num : numberArray) {
            sum += num.doubleValue();
            if (num instanceof Double || num instanceof Float) {
                hasFloatingPoint = true;
            }
        }
        return hasFloatingPoint ? sum : (sum % 1 == 0 ? (long) sum : sum);
    }

}