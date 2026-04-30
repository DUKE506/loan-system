package com.duke.loan_system.user_context.domain;

import com.duke.loan_system.domain.CreditGrade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DDDUser {
    private Long id;
    private String name;
    private String rnn;
    private String phone;
    private CreditGrade creditGrade;
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
