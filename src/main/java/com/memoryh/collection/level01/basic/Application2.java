package com.memoryh.collection.level01.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.join;

/*
사용자가 방문한 웹사이트 URL을 입력받아 저장하고, 가장 최근에 방문한 5개의 URL을 출력하는 프로그램을 작성하세요.

방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
최근 방문 url : [https://www.google.com/]
방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
최근 방문 url : [https://github.com/, https://www.google.com/]
방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.notion.so/
최근 방문 url : [https://www.notion.so/, https://github.com/, https://www.google.com/]
방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.naver.com/
최근 방문 url : [https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
최근 방문 url : [https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
최근 방문 url : [https://www.google.com/, https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/]
방문 URL을 입력하세요 (단, exit를 입력하면 종료) : exit
 */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX_RECENT_URLS = 5;

    public static void main(String[] args) {
        List<String> visitedUrls = new ArrayList<>();

        while (true) {
            String url = getUserInputUrl();
            if (url.equals("exit")) {
                break;
            }
            visitedUrls.add(url);
            printRecentUrls(visitedUrls);
        }
    }

    private static void printEndMessage() {
        System.out.println("]");
    }

    private static void printStartMessage() {
        System.out.print("최근 방문 url : [");
    }

    private static void printRecentUrls(final List<String> urls) {
        List<String> recentUrls = new ArrayList<>();
        printStartMessage();
        for (int i = urls.size() - 1; i >= Math.max(urls.size() - MAX_RECENT_URLS, 0); i--) {
            recentUrls.add(urls.get(i));
        }
        System.out.print(join(", ", recentUrls));
        printEndMessage();
    }

    private static String getUserInputUrl() {
        System.out.print("방문 URL을 입력하세여 (단, exit를 입력하면 종료) : ");
        return sc.nextLine();
    }

}