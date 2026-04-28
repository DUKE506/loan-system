package com.duke.loan_system.domain;

import jakarta.persistence.*;

@Entity(name = "users")
public class User {
    //식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //고객명
    @Column
    private String name;

    //주민번호
    @Column
    private String rnn;

    //신용등급
    @Column
    @Enumerated(value = EnumType.STRING)
    private CreditGrade creditGrade;

    //잔액
    @Column
    private int balance = 500000;

    // 기본 생성자
    public User(){}

    //// 식별자 GETTER, SETTER
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    //// 이름 GETTER, SETTER
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    //// 주민번호 GETTER, SETTER
    public String getRnn(){return rnn;}
    public void setRnn(String rnn) {this.rnn = rnn;}

    //// 신용등급 GETTER, SETTER
    public CreditGrade getCreditGrade(){
        return creditGrade;
    }
    public void setCreditGrade(CreditGrade creditGrade){
        this.creditGrade= creditGrade;
    }

    //// 잔액 GETTER, SETTER
    public int getBalance(){return balance;}
    public void setBalance(Integer balance){this.balance = balance;}

    //메서드
    /// 잔액 추가
    public void addBalance(int amount){
        if(amount <= 0 ){
            throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
        }
        this.balance += amount;
    }

    /// 잔액 차감
    public void deductBalance(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
        }
        if(this.balance < amount){
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        this.balance -= amount;
    }


}
