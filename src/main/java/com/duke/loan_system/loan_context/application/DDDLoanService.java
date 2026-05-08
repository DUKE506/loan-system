package com.duke.loan_system.loan_context.application;

import com.duke.loan_system.loan_context.application.command.ApplyLoanCommand;
import org.springframework.stereotype.Service;

@Service
public class DDDLoanService {

    //도메인 서비스 주입
    //리포지토리 interface 주입
    public DDDLoanService(){}


    // 대출 신청
    public void applyLoan(ApplyLoanCommand applyLoanCommand){
        // 1. 사용자 조회 // 실제적으론 인증된 사용자이기에 별도로 할 필요는 없음
        // 2. 신용등급 C 미만이면 Cut
        // 3. 대출 생성
        // 4. 대출 심사 생성
    }
}
