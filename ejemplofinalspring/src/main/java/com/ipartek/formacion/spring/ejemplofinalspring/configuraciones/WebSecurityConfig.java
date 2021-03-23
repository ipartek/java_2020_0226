package com.ipartek.formacion.spring.ejemplofinalspring.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.anyRequest().permitAll()
			//.antMatchers("/**").permitAll()
			//.anyRequest().authenticated()
			.and()
		.formLogin()
			//.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}

	// https://www.baeldung.com/spring-security-jdbc-authentication
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
		// NoOpPasswordEncoder es un NO codificador de passwords (contraseñas en texto plano)
		// Recomendable utilizar contraseñas con BCryptPasswordEncoder
	    auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance()) //new BCryptPasswordEncoder())
	    .usersByUsernameQuery("select email,password,1 "
	            + "from usuarios "
	            + "where email = ?")
	          .authoritiesByUsernameQuery("select email,'ROLE_USER' "
	            + "from usuarios "
	            + "where email = ?");
	}

// https://www.browserling.com/tools/bcrypt
	
//	CREATE TABLE users (
//			  username VARCHAR(50) NOT NULL,
//			  password VARCHAR(100) NOT NULL,
//			  enabled TINYINT NOT NULL DEFAULT 1,
//			  PRIMARY KEY (username)
//			);
//			  
//			CREATE TABLE authorities (
//			  username VARCHAR(50) NOT NULL,
//			  authority VARCHAR(50) NOT NULL,
//			  FOREIGN KEY (username) REFERENCES users(username)
//			);
//
//			CREATE UNIQUE INDEX ix_auth_username
//			  on authorities (username,authority);
//	-- User user/pass
//	INSERT INTO users (username, password, enabled)
//	  values ('user',
//	    '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
//	    1);
//
//	INSERT INTO authorities (username, authority)
//	  values ('user', 'ROLE_USER');
}
