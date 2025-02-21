package com.memoryh.class_and_object.level01.basic.student.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private int grade;
    private int classroom;
    private String name;
    private int kor;
    private int eng;
    private int math;

    public String getInformation() {
        return "학년=" + grade + ", 반=" + classroom + ", 이름=" + name
                + ", 국어=" + kor + ", 영어=" + eng + ", 수학=" + math;
    }

}