package com.duke.loan_system.user_context.infrastructure;


import com.duke.loan_system.domain.CreditGrade;
import com.duke.loan_system.user_context.domain.DDDUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name ="ddd-users")
@Getter
@Setter
public class UserJpaEntity {
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

    public UserJpaEntity(){};



//    JPA -> 도메인
    public DDDUser toDomain(){
        return DDDUser.of(this.id, this.name, this.rnn, this.phone,this.creditGrade, this.balance);
    }
//    도메인 -> JPA
    public static UserJpaEntity from(DDDUser user){
        UserJpaEntity entity = new UserJpaEntity();
        entity.name = user.getName();
        entity.rnn = user.getRnn();
        entity.phone = user.getPhone();
        entity.creditGrade = user.getCreditGrade();
        entity.balance = user.getBalance();
        return entity;
    }

}
