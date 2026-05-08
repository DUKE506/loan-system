package com.duke.loan_system.user_context.domain;

import com.duke.loan_system.domain.CreditGrade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DDDUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String rnn;
    @Column
    private String phone;
    @Column
    @Enumerated(value = EnumType.STRING)
    private CreditGrade creditGrade;
    @Column
    private int balance;

    //Methods
    public static DDDUser createUser(String name, String rnn, String phone){
        DDDUser user = new DDDUser();
        user.name = name;
        user.rnn = rnn;
        user.phone = phone;
        user.creditGrade = CreditGrade.B;
        user.balance = 0;
        return user;
    }

    public static DDDUser of(Long id, String name, String rnn, String phone,CreditGrade creditGrade,int balance){
        DDDUser user = new DDDUser();
        user.id = id;
        user.name = name;
        user.rnn = rnn;
        user.phone = phone;
        user.creditGrade = creditGrade;
        user.balance = balance;
        return user;
    }
}
