package br.com.cmabreu.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
        	.logout().logoutSuccessUrl("http://localhost:8180/guardiao/exit")	
        .and()
            .authorizeRequests()
    		.antMatchers("/resources/**").permitAll()
    	.and()
    		.authorizeRequests()
            .anyRequest()
            .authenticated();
    }

}
