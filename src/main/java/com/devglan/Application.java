package com.devglan;

import com.devglan.dao.ReferralCodeRepository;
import com.devglan.dao.UserRepository;
import com.devglan.model.ReferralCode;
import com.devglan.model.User;
import com.devglan.service.impl.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ReferralCodeRepository referralCodeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NextSequenceService nextSequenceService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        ReferralCode rc = new ReferralCode();
        rc.setReferralCode("VDGDFOJKKDFGJK");
        rc.setReferredBy("34");
        rc.setId(nextSequenceService.getNextSequence(ReferralCode.SEQ_NAME));


        User user = new User();
        String id = "1";
        user.setId(id);
        user.setFirstName("Shravan");
        user.setLastName("Maridi");
        user.setMobile("9000022200");

        System.out.println(userRepository.findById("5ddf811c69b6ac0c98847704" +
                "" +
                "").isPresent());
     if(userRepository.findById(id).isPresent()==false)
      userRepository.save(user);
    //    referralCodeRepository.save(rc);
    }

}
