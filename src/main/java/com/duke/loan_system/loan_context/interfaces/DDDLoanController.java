package com.duke.loan_system.loan_context.interfaces;

import com.duke.loan_system.loan_context.interfaces.dto.ApplyLoanDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ddd-loan")
public class DDDLoanController {

    //대출 신청
    public void requestLoan(@RequestBody() ApplyLoanDTO applyLoanDTO){

    }

    //대출 조회
}
