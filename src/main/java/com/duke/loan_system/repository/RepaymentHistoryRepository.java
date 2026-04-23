package com.duke.loan_system.repository;

import com.duke.loan_system.domain.RepaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepaymentHistoryRepository extends JpaRepository<RepaymentHistory,Long> {
}
