package com.stone.study.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationManager myAuthenticationManager;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(null, ChannelProcessingFilter.class).authorizeRequests().antMatchers("/");
		super.configure(http);
	}

}
