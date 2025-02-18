package com.memoryh.level02.normal;

import java.util.List;
import java.util.Random;

public class RandomMaker {

    private static final Random random = new Random();

    public static int randomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static String randomUpperAlphabet(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    public static String rockPaperScissors() {
        List<String> rockPaperScissorsArr = List.of("가위", "바위", "보");
        return rockPaperScissorsArr.get(random.nextInt(rockPaperScissorsArr.size()));
    }

    public static String tossCoin() {
        List<String> coin = List.of("앞면", "뒷면");
        return coin.get(random.nextInt(coin.size()));
    }

}