package com.memoryh.array.level04.advanced;

import java.util.*;

/* 숫자 야구게임 만들기
 * 길이 4의 정수 배열을 만들고 각 인덱스에는 0 ~ 9까지의 중복되지 않는 난수를 저장한다.
 * 4자리 숫자를 입력받아 스트라이크, 볼 등의 힌트를 주며 4자리 난수 숫자를 맞추는 게임이다.
 * 숫자와 자리가 모두 맞는 경우 스트라이크, 숫자는 맞지만 자리는 맞지 않는 경우는 볼 이다.
 * 예) 9183 으로 난수가 발생하면 9356 입력 시 1S 1B이다.
 *
 * 단, 기회는 총 10번이며, 10번 이내에 맞추는 경우 "정답입니다." 출력 후 게임 종료
 * 10번의 기회가 모두 소진 되면 "10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다." 출력 후 종료
 *
 * 또한 4자리의 정수를 입력하지 않은 경우에는 "4자리의 정수를 입력해야 합니다." 출력 후 입력을 다시 받을 수 있되
 * 횟수는 차감하지 않는다.
 *
 * -- 프로그램 예시 (난수 7416 의 경우) --
 *
 * 10회 남으셨습니다.
 * 4자리 숫자를 입력하세요 : 1234
 * 아쉽네요 0S 2B 입니다.
 * 9회 남으셨습니다.
 * 4자리 숫자를 입력하세요 : 5678
 * 아쉽네요 0S 2B 입니다.
 * 8회 남으셨습니다.
 * 4자리 숫자를 입력하세요 : 7416
 * 정답입니다.
 * */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);
    private static final String TARGET_NUMBER = generateUniqueTargetNumber();
    private static final String FOUR_DIGIT_NUMBER_REGEX = "\\d{4}";
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int TARGET_LENGTH = 4;

    private static int remainingAttempts = 10;
    private static boolean[] isStrike;

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        System.out.println(TARGET_NUMBER);
        String baseballNumber = getUserInput();
        char[] userDigits = baseballNumber.toCharArray();
        isStrike = new boolean[TARGET_LENGTH];
        checkGuess(userDigits);
        sc.close();
    }

    private static void checkGuess(char[] arrBaseballNumbers) {
        int strike = countStrikes(arrBaseballNumbers);
        int ball = countBalls(arrBaseballNumbers);
        handleGuessResult(strike, ball);
    }

    private static void handleGuessResult(final int strike, final int ball) {
        if (strike == 4) {
            System.out.println("정답입니다.");
        } else {
            remainingAttempts--;
            System.out.printf("아쉽네요 %dS %dB 입니다.\n", strike, ball);

            if (remainingAttempts == 0) {
                System.out.println("10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다.");
                return;
            }
            playGame();
        }
    }

    private static int countBalls(final char[] arrBaseballNumbers) {
        int ballCount = 0;

        for (int i = 0; i < TARGET_LENGTH; i++) {
            for (char arrBaseballNumber : arrBaseballNumbers) {
                if (!isStrike[i] && TARGET_NUMBER.charAt(i) == arrBaseballNumber) {
                    ballCount++;
                    isStrike[i] = true;
                    break;
                }
            }
        }
        return ballCount;
    }

    private static int countStrikes(final char[] arrBaseballNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < TARGET_NUMBER.length(); i++) {
            if (TARGET_NUMBER.charAt(i) == arrBaseballNumbers[i]) {
                strikeCount++;
                isStrike[i] = true;
            }
        }
        return strikeCount;
    }

    private static void validateUserInput(final String userInput) {
        if (userInput.length() != TARGET_LENGTH || !userInput.matches(FOUR_DIGIT_NUMBER_REGEX)) {
            throw new IllegalArgumentException("4자리의 정수를 입력해야 합니다.");
        }
    }

    private static String getUserInput() {
        try {
            System.out.printf("%d회 남으셨습니다.\n", remainingAttempts);
            System.out.print("4자리 숫자를 입력하세요 : ");
            String userInput = sc.nextLine();
            validateUserInput(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserInput();
        }
    }

    private static String generateUniqueTargetNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        Set<Integer> uniqueDigits = new LinkedHashSet<>();

        while (uniqueDigits.size() < TARGET_LENGTH) {
            uniqueDigits.add(random.nextInt(RANDOM_NUMBER_BOUND));
        }

        for (int number : uniqueDigits) {
            sb.append(number);
        }
        return sb.toString();
    }

}