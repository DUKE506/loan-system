package com.duke.loan_system.domain;

import jakarta.persistence.*;

@Entity(name = "users")
@Table
public class User {
    //식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //고객명
    @Column
    private String name;

    //신용등급
    @Column
    @Enumerated(value = EnumType.STRING)
    private CreditGrade creditGrade;

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

    //// 신용등급 GETTER, SETTER
    public CreditGrade getCreditGrade(){
        return creditGrade;
    }
    public void setCreditGrade(CreditGrade creditGrade){
        this.creditGrade= creditGrade;
    }


}
