package com.memoryh.array.level04.advanced;

import java.util.*;

/* 로또번호 생성기
 * 6칸 짜리 정수 배열을 하나 생성하고
 * 1부터 45까지의 중복되지 않는 난수를 발생시켜 각 인덱스에 대입한 뒤
 * 오름차순 정렬하여 출력하세요.
 * Arrays.sort(배열) 메소드 활용하여 정렬 가능.
 * */
public class Application1 {

    private static final int LOTTO_COUNT = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public static void main(String[] args) {
        int[] lottoNumbers = generateUniqueLottoNumbers();
        Arrays.sort(lottoNumbers);
        printLottoNumbers(lottoNumbers);
    }

    private static void printLottoNumbers(final int[] lottoNumbers) {
        System.out.println(Arrays.toString(lottoNumbers));
    }

    private static int[] generateUniqueLottoNumbers() {
        Random random = new Random();
        Set<Integer> uniqueLottoNumbers = new HashSet<>();

        while (uniqueLottoNumbers.size() < LOTTO_COUNT) {
            int lottoNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            uniqueLottoNumbers.add(lottoNumber);
        }
        return uniqueLottoNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}