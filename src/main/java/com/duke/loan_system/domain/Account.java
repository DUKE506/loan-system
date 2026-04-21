package com.duke.loan_system.domain;

public class Account {
    //식별자
    private Long id;
    //계좌명
    private String name;
    //계좌번호
    private String number; // 형식 : 6자-2자-6자
    //상태 (사용, 정지)
    private Boolean isActive;
    //잔액
    private Integer balance;
}
