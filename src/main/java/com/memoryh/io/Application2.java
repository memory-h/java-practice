package com.memoryh.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/* ----- 입력 예시 -----
 *
 * (원본 파일이 존재 하는 경우)
 * 원본 파일의 이름을 입력하세요 : origin.txt
 * 복사 파일의 이름을 입력하세요 : copy.txt
 *
 * ----- 출력 예시 -----
 *
 * 파일 복사가 성공적으로 완료 되었습니다.
 *
 * ----- 입력 예시 -----
 *
 * (원본 파일이 존재하지 않는 경우)
 * 원본 파일의 이름을 입력하세요 : origin2.txt
 * 복사 파일의 이름을 입력하세요 : copy2.txt
 *
 * ----- 출력 예시 -----
 *
 * 오류 : origin2.txt (지정된 파일을 찾을 수 없습니다)
 *
 */
public class Application2 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String originFileName = getOriginFileName();
        String copyFIleName = getCopyFIleName();

        Path originPath = Paths.get(originFileName);
        Path copyPath = Paths.get(copyFIleName);

        try {
            Files.copy(originPath, copyPath);
        } catch (FileAlreadyExistsException e) {
            System.out.println("오류 : " + copyFIleName + " (이미 존재하는 파일입니다.)");
        } catch (NoSuchFileException e) {
            System.out.println("오류 : " + originFileName + " (지정된 파일을 찾을 수 없습니다)");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }

    private static String getCopyFIleName() {
        System.out.print("복사 파일의 이름을 입력하세요 : ");
        return sc.nextLine();
    }

    private static String getOriginFileName() {
        System.out.print("원본 파일 이름을 입력하세요 : ");
        return sc.nextLine();
    }

}