package com.example.restaurant_app.configuration.security;

import com.example.restaurant_app.model.dao.AuthorityEntity;
import com.example.restaurant_app.model.dao.UserEntity;
import com.example.restaurant_app.repository.AuthorityRepository;
import com.example.restaurant_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DataProvider implements CommandLineRunner {


    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) throws Exception {

            AuthorityEntity userRole = new AuthorityEntity();
            userRole.setName("ROLE_USER");
            userRole = authorityRepository.save(userRole);

            AuthorityEntity adminRole = new AuthorityEntity();
            adminRole.setName("ROLE_ADMIN");
            adminRole = authorityRepository.save(adminRole);

            UserEntity user = new UserEntity();
            user.setUsername("Admin");
            user.setMail("Admin@gmail.com");
            user.setPassword(passwordEncoder.encode("Admin123"));
            user.setActive(true);
            user.setAuthorities(Arrays.asList(userRole));
            userRepository.save(user);
        }
}
