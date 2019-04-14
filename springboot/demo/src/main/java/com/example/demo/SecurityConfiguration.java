package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan("com.chuanzhi.workspace.service.impl.*")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置user-detail服务
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
            .withUser("rg2")
            .password("123456")
            .roles("USER").and()
            .withUser("aa")
            .password("123456")
            .roles("");
    }
    /**
     * 拦截请求
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http)throws Exception{
    	http
    	.authorizeRequests().antMatchers("/**").hasRole("USER").and().httpBasic().and()
    	.formLogin()
            .failureForwardUrl("/?error=ture")
            .successForwardUrl("/hello").and()
        .logout()
        	.logoutUrl("/logout").permitAll()
        	.logoutSuccessUrl("/?logout=true").and()
        .rememberMe()
        	.tokenValiditySeconds(604800)
        	.rememberMeParameter("remember-me")
        	.rememberMeCookieName("workspace");
    }

    /**
     * 拦截请求
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {

    }
    }