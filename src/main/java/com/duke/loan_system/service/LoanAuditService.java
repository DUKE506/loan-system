package com.duke.loan_system.service;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.domain.LoanAudit;
import com.duke.loan_system.domain.LoanAuditStatus;
import com.duke.loan_system.domain.LoanStatus;
import com.duke.loan_system.dto.loanAudit.ApprovalLoanAuditDTO;
import com.duke.loan_system.dto.loanAudit.RejectLoanAuditDTO;
import com.duke.loan_system.repository.LoanAuditRepository;
import com.duke.loan_system.repository.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanAuditService {
    private LoanAuditRepository loanAuditRepository;
    private LoanRepository loanRepository;

    public LoanAuditService( LoanAuditRepository loanAuditRepository,LoanRepository loanRepository){
        this.loanAuditRepository = loanAuditRepository;
        this.loanRepository = loanRepository;
    }

    //대출 심사 승인
    public LoanAudit approvalLoan(ApprovalLoanAuditDTO approvalLoanAuditDTO){
        //대출 조회
        Loan loan = loanRepository.findById(approvalLoanAuditDTO.getLoanId())
                .orElseThrow(()-> new IllegalArgumentException("대출이 존재하지 않습니다."));
        //심사 조회
        LoanAudit loanAudit = loanAuditRepository.findByLoanInfo(loan)
                .orElseThrow(()-> new IllegalArgumentException("심사중인 대출이 존재하지않습니다."));

        //심사 승인
        loanAudit.setAuditStatus(LoanAuditStatus.APPROVED);
        //대출 상태 변경
        loan.setStatus(LoanStatus.APPROVED);
        loanRepository.save(loan);
        return loanAuditRepository.save(loanAudit);
    }

    //대출 심사 거부
    public LoanAudit rejectLoan(RejectLoanAuditDTO rejectLoanAuditDTO){
        //대출 조회
        Loan loan = loanRepository.findById(rejectLoanAuditDTO.getLoanId())
                .orElseThrow(()-> new IllegalArgumentException("대출이 존재하지 않습니다."));

        //심사 조회
        LoanAudit loanAudit = loanAuditRepository.findByLoanInfo(loan)
                .orElseThrow(()-> new IllegalArgumentException("심사중인 대출이 존재하지않습니다."));

        //심사 거부
        loanAudit.setAuditStatus(LoanAuditStatus.REJECTED);
        loanAudit.setNote(rejectLoanAuditDTO.getRejectMessage());

        //대출 상태 변경
        loan.setStatus(LoanStatus.REJECTED);
        loanRepository.save(loan);

        return loanAuditRepository.save(loanAudit);
    }
}
