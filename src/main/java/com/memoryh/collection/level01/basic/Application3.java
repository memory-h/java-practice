package com.memoryh.collection.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
대기 줄을 시뮬레이션하는 프로그램을 작성하세요. 고객이 줄을 서면 대기열에 추가되고, 서비스가 완료되면 대기열에서 제거합니다.

대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 유관순
유관순 고객님 대기 등록 되었습니다.
대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 홍길동
홍길동 고객님 대기 등록 되었습니다.
대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
유관순 고객님 차례입니다.
대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 신사임당
신사임당 고객님 대기 등록 되었습니다.
대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
홍길동 고객님 차례입니다.
대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
신사임당 고객님 차례입니다.
대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
대기 고객이 없습니다.
대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): exit
 */
public class Application3 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Queue<String> customerNames = new LinkedList<>();

        while (true) {
            String customerName = getCustomerName();

            if (customerName.equals("exit")) {
                break;
            }
            if (customerName.equals("next")) {
                if (customerNames.isEmpty()) {
                    printNoWaitingCustomersMessage();
                } else {
                    printAnnounceCustomerTurn(customerNames.poll());
                }
                continue;
            }
            customerNames.offer(customerName);
            printConfirmCustomerAdded(customerName);
        }
    }

    private static void printNoWaitingCustomersMessage() {
        System.out.println("대기 고객이 없습니다.");
    }

    private static void printAnnounceCustomerTurn(final String customerName) {
        System.out.println(customerName + " 고객님 차례입니다.");
    }

    private static void printConfirmCustomerAdded(final String customerName) {
        System.out.println(customerName + " 고객님 대기 등록 되었습니다.");
    }

    private static String getCustomerName() {
        System.out.print("대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): ");
        return sc.nextLine();
    }

}