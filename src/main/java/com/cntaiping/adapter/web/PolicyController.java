package com.cntaiping.adapter.web;

import com.cntaiping.adapter.output.PolicyOutput;
import com.cntaiping.application.service.PolicyApplicationService;
import com.cntaiping.domain.policy.factory.PolicyFactory;
import io.swagger.v3.oas.annotations.Operation;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyApplicationService policyApplicationService;
    @Operation(summary = "保单初审注册")
    @PostMapping
    public ResponseEntity<PolicyOutput> create(
            @Length(min = 20,max = 20, message = "policyNo 长度异常") @RequestParam("policyNo") String policyNo) {

        return ResponseEntity
                .ok()
                .body(policyApplicationService.createNBPolicy(policyNo));
    }
}
