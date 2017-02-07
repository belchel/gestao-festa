package com.tr.festa.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter  {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		builder
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username,password, enabled from users where username=?")
			.authoritiesByUsernameQuery(
					"select username, role from user_roles where username=?");
	}
	
}
