package com.jjh.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        System.out.println("WebSecurityConfig.configure(auth)");
        auth.inMemoryAuthentication()
                .withUser("jeh")
                .password("{noop}user123") // Otherwise expects encoded password
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("WebSecurityConfig.configure(http)");
        //HTTP Basic authentication - .antMatchers("/welcome/help/**")
        // Cross-Site Request Forgery protection turned on by default (see also .cors() Cross Origin Requests)
        // can turn off with .csrf().disable()

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/books/list").hasRole("USER");
    }

}
