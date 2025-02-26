package com.memoryh.io.level02.normal;

import java.io.*;
import java.util.Scanner;

public class Application1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int fileCount = getTotalFileCount();
            String[] fileNames = getFileName(fileCount);
            String mergeFileName = getMergeFileName();
            mergeFiles(fileCount, fileNames, mergeFileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mergeFiles(int fileCount, final String[] fileNames, final String mergeFileName) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < fileCount; i++){
            BufferedReader fileReader;
            try {
                fileReader = new BufferedReader(new FileReader(fileNames[i]));
            } catch (FileNotFoundException e) {
                System.out.println("오류 : " + fileNames[i] + " (지정된 파일을 찾을 수 없습니다)");
                return;
            }
            appendReadFile(fileReader, sb);
            fileReader.close();
        }
        createMergeFile(mergeFileName, sb);
    }

    private static void printFileMergeSuccessMessage() {
        System.out.println("파일 병합이 완료되었습니다.");
    }

    private static void createMergeFile(final String mergeFileName, final StringBuilder sb) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(mergeFileName));
        fileWriter.write(sb.toString());
        fileWriter.flush();
        fileWriter.close();

        printFileMergeSuccessMessage();
    }

    private static void appendReadFile(final BufferedReader fileReader, final StringBuilder sb) throws IOException {
        String str;

        while ((str = fileReader.readLine()) != null) {
            sb.append(str).append("\n");
        }
    }

    private static String getMergeFileName() throws IOException {
        System.out.print("병합될 파일명 입력 : ");
        return readUserInput();
    }

    private static String[] getFileName(final int fileCount) throws IOException {
        String[] fileNames = new String[fileCount];

        for (int i = 0; i < fileCount; i++) {
            System.out.print((i + 1) + "번째 파일 이름 입력 : ");
            fileNames[i] = readUserInput();
        }
        return fileNames;
    }

    private static int getTotalFileCount() throws IOException {
        System.out.print("병합할 파일의 개수 입력 : ");
        return Integer.parseInt(readUserInput());
    }

    private static String readUserInput() {
        return sc.nextLine();
    }

}