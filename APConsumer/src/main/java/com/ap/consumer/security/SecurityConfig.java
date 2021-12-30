package com.ap.consumer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.mvcMatchers("/","/loginForm","/signupForm","/signup").permitAll()
			.mvcMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/css/**","/js/**","/img/**").permitAll()
			.anyRequest().authenticated();
		
		http.formLogin()
			.loginPage("/loginForm")
			.loginProcessingUrl("/doLogin")
			.defaultSuccessUrl("/success", true);
		
		http.httpBasic();
		
		http.logout().logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
