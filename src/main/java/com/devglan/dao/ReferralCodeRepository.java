package com.devglan.dao;


import java.util.List;

import com.devglan.model.ReferralCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralCodeRepository extends MongoRepository<ReferralCode, String> {

    public ReferralCode findByReferralCode(String referralCode);

    public List<ReferralCode> findByReferredBy(String referredBy);

}
