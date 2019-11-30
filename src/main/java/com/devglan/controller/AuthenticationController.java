package com.devglan.controller;

import com.devglan.config.TokenProvider;
import com.devglan.dao.UserRepository;
import com.devglan.model.CustomAuthentication;
import com.devglan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/generate-affiliate-token", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody String mobileNumber) throws AuthenticationException {

        User user = userRepository.findByMobile(mobileNumber);
        System.out.println(user);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        List<SimpleGrantedAuthority> sa = new ArrayList<SimpleGrantedAuthority>();
        SimpleGrantedAuthority s1 = new SimpleGrantedAuthority("ROLE_AFFILIATE");

        sa.add(s1);
        CustomAuthentication ca = new CustomAuthentication(user, "", sa);
        SecurityContextHolder.getContext().setAuthentication(ca);
        final String token = jwtTokenUtil.generateToken(ca);
        return ResponseEntity.ok(token);
    }


}
