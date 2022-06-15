package com.example.restaurant_app.security;

import com.example.restaurant_app.repository.UserRepository;
import com.example.restaurant_app.security.filter.CustomAuthenticationFilter;
import com.example.restaurant_app.security.filter.CustomAuthorizationFilter;
import com.example.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .headers().frameOptions().sameOrigin().and()
                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .addFilter(new CustomAuthenticationFilter(authenticationManager(),userRepository))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/api/menu", "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/api/pizzas/**").permitAll()
                .antMatchers("/h2-console/**", "/h2-console").permitAll()
                .antMatchers(HttpMethod.POST, "/api/users").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users/current").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/users/*").authenticated()
                .antMatchers("/api/orders", "/api/pizza-ratings/**", "/api/orders").authenticated()
                .antMatchers("/api/users*/**","/api/allOrders", "/api/backup").hasAnyRole("ADMIN")
                .anyRequest().denyAll();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
