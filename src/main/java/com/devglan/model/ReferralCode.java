package com.devglan.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document(collection = "referral_codes")
public class ReferralCode {


    public static final String SEQ_NAME = "referral_code";

    @Id
    private String id;
    @Indexed(unique=true)
    private String referralCode;
    @NotNull
    private String referredBy;
    private Date referredOn = new Date();
    private boolean isUsed = false;
    private Date usedOn;
    private Float preDiscountAmount;
    private Float discountAmount;
    private Float commission;

}
