package com.duke.loan_system.repository;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.domain.LoanAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanAuditRepository extends JpaRepository<LoanAudit,Long> {

    //대출기반 조회
    Optional<LoanAudit> findByLoanInfo(Loan loan);
}
