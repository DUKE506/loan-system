package com.duke.loan_system.dto.repaymentHistory;

import com.duke.loan_system.domain.RepaymentHistory;
import lombok.Getter;

import java.util.Date;

@Getter
public class RepaymentResponseDTO {
    private Long id;

    private int repayment;

    private Date repaymentDate;

    // 대출ID
    private Long loanId;
    // 대출금
    private int amount;
    // 잔금
    private int balance;
    // 납부횟수
    private int paymentCount;

    // 사용자ID
    private Long userId;
    private String userName;


    public RepaymentResponseDTO(){}

    public static RepaymentResponseDTO from(RepaymentHistory repaymentHistory){
        RepaymentResponseDTO dto = new RepaymentResponseDTO();
        dto.id = repaymentHistory.getId();
        dto.repayment = repaymentHistory.getRepayment();
        dto.repaymentDate = repaymentHistory.getRepaymentDate();
        dto.loanId = repaymentHistory.getLoanInfo().getId();
        dto.amount = repaymentHistory.getLoanInfo().getAmount();
        dto.balance = repaymentHistory.getLoanInfo().getBalance();
        dto.paymentCount = repaymentHistory.getLoanInfo().getPaymentCount();
        dto.userId = repaymentHistory.getApplicant().getId();
        dto.userName = repaymentHistory.getApplicant().getName();

        return dto;
    }

}
