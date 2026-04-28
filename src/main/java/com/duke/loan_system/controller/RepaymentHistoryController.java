package com.duke.loan_system.controller;

import com.duke.loan_system.domain.RepaymentHistory;
import com.duke.loan_system.dto.repaymentHistory.RepaymentExecutionDTO;
import com.duke.loan_system.dto.repaymentHistory.RepaymentResponseDTO;
import com.duke.loan_system.service.RepaymentHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repayment")
public class RepaymentHistoryController {

    private RepaymentHistoryService repaymentHistoryService;

    public RepaymentHistoryController(RepaymentHistoryService repaymentHistoryService){
        this.repaymentHistoryService= repaymentHistoryService;
    }

    @GetMapping()
    public ResponseEntity<List<RepaymentResponseDTO>> findAllRepaymentHistory(){
        List<RepaymentResponseDTO> histories = repaymentHistoryService.findAllRepaymentHistory();
        return ResponseEntity.ok(histories);
    }

    @PostMapping()
    public ResponseEntity<RepaymentResponseDTO> repaymentExecute(@RequestBody RepaymentExecutionDTO repaymentExecutionDTO){
        RepaymentResponseDTO history = repaymentHistoryService.repaymentExecute(repaymentExecutionDTO);

        return ResponseEntity.status(201).body(history);
    }

}
