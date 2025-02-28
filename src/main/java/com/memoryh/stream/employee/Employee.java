package com.memoryh.stream.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {

    private String name;
    private int age;
    private String department;
    private int salary;

}