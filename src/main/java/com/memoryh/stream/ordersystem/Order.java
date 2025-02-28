package com.memoryh.stream.ordersystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Order {

    private String orderId;
    private String customerName;
    private List<String> items;
    private double totalAmount;
    private String status;

}