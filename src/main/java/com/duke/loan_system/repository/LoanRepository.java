package com.duke.loan_system.repository;

import com.duke.loan_system.domain.Loan;
import com.duke.loan_system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Long> {

    //사용자 기반 조회
    List<Loan> findByApplicant(User applicant);
}
