package com.example.restaurant_app.configuration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.restaurant_app.model.dao.UserEntity;
import com.example.restaurant_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserDerailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final HttpServletResponse httpServletResponse;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(username));

//        String token = JWT.create()
//                .withSubject(user.getUsername() + user.getMail())
//                .withExpiresAt(new Date(System.currentTimeMillis() + 3000))
//                .sign(Algorithm.HMAC256("secret"));
//        System.out.println(token);
//        try {
//            httpServletResponse.getOutputStream().print("{\"token\": \"" + token + "\"}");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return User.builder()
                .username(user.getMail())
                .password(user.getPassword())
                .accountLocked(!user.isActive())
                .authorities(user.getAuthorities()
                        .stream().map(x -> x.getName())
                        .toArray(String[]::new))
                .build();
    }
}
