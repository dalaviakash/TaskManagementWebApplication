package com.jspider.TaskManagementWebApplication.Controller;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

    @EnableWebSecurity
    public class TaskSecurityConfiguration  extends WebSecurityConfigurerAdapter {
        //Authentication


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            User.UserBuilder user=User.withDefaultPasswordEncoder();
            auth.inMemoryAuthentication()
                    .withUser((user.username("Task").password("Task@123").roles("ADMIN")))//this is user name and password for admin
                   .withUser((user.username("akash").password("456").roles(" login EMPLOYEE")));

        }

        //Autherization

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests()

                    .antMatchers("/").hasRole("ADMIN")//only access to giv admin
                    .antMatchers("/employee").hasAnyRole("login EMPLOYEE","ADMIN")
                    .and().formLogin()
                    .and().logout(); //type logout in url

        }
    }


