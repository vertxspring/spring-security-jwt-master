package com.devglan.controller;

import com.devglan.dao.ReferralCodeRepository;
import com.devglan.model.CustomAuthentication;
import com.devglan.model.ReferralCode;
import com.devglan.service.impl.NextSequenceService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReferralCodeController {

    @Autowired
    NextSequenceService nextSequenceService;

    @Autowired
    ReferralCodeRepository referralCodeRepository;

    @RequestMapping(value = "/generate-referral", method = RequestMethod.POST)
    public ResponseEntity<String> getReferralCode() {
        String referralCode;
        while(true) {
            referralCode = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
            if(referralCodeRepository.findByReferralCode(referralCode)==null){
                break;
            }
        }
        ReferralCode rc = new ReferralCode();
        CustomAuthentication ca = (CustomAuthentication) SecurityContextHolder.getContext().getAuthentication();
        rc.setReferralCode(referralCode);
        rc.setReferredBy(ca.getPrincipal().getId());
        rc.setId(nextSequenceService.getNextSequence(ReferralCode.SEQ_NAME));

        referralCodeRepository.save(rc);
        return ResponseEntity.ok(referralCode);

    }
}
