package com.barbershop.com.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

	    @Autowired
	    private ImplementUserDetailService detail;
	   
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http
			.authorizeRequests ()
			.antMatchers(HttpMethod.GET,"/").permitAll()
			.anyRequest (). authenticated ()
			.and()
			.formLogin().permitAll ()
			.loginPage("/login")
			.defaultSuccessUrl("/adminProfile")
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/");
	}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
			   auth
			   .userDetailsService(detail)
			   .passwordEncoder(new BCryptPasswordEncoder());
			 
		       
		}
		
		
		@Override
		public void configure(WebSecurity web) throws Exception {
		
			web.ignoring().antMatchers("/css/**");
			web.ignoring().antMatchers("/images/**");
			web.ignoring().antMatchers("/javascripts/**");
		}
		
}	
		