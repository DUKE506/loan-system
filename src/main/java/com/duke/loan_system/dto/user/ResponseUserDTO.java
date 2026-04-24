package com.duke.loan_system.dto.user;

import com.duke.loan_system.domain.CreditGrade;
import com.duke.loan_system.domain.User;
import lombok.ToString;

@ToString
public class ResponseUserDTO {
    private Long id;
    private String name;
    private CreditGrade creditGrade;
    private int balance;


    public ResponseUserDTO(){};

    public ResponseUserDTO(User user){
        this.id = user.getId();
        this.name= user.getName();
        this.creditGrade = user.getCreditGrade();
        this.balance = user.getBalance();
    };

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getName(){return name;}
    public void setName(String name){ this.name = name;}

    public CreditGrade getCreditGrade(){return creditGrade;}
    public void setCreditGrade(CreditGrade creditGrade){this.creditGrade = creditGrade;}

    public int getBalance(){return balance;}
    public void setBalance(int balance){this.balance = balance;}

}
