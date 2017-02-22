package com.niit.shoppingcart.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select mail, password, true from user where mail=?")
		.authoritiesByUsernameQuery(
			"select mail, role from user where mail=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/category").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/addcategory").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/categorytable").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/manage_category_remove").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/manage_category_edit").access("hasRole('ROLE_ADMIN')")
		
		.antMatchers("/subcategory").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/addsubcategory").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/subcategorytable").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/manage_subcategory_remove").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/manage_subcategory_edit").access("hasRole('ROLE_ADMIN')")
		
		.antMatchers("/supplier").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/addsupplier").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/suppliertable").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/manage_supplier_remove").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/manage_supplier_edit").access("hasRole('ROLE_ADMIN')")
		
		.antMatchers("/product").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/addproduct").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/producttable").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/manage_product_remove").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/manage_product_edit").access("hasRole('ROLE_ADMIN')")
		
		.antMatchers("/cartTable").access("hasRole('ROLE_USER')")
		.antMatchers("/addToCart").access("hasRole('ROLE_USER')")
		.antMatchers("/manage_cart_remove").access("hasRole('ROLE_USER')")
		.antMatchers("/manage_cart_remove").access("hasRole('ROLE_USER')")
		
		.antMatchers("/checkout.xml").access("hasRole('ROLE_USER')")
		
		.and()
		  .formLogin().loginPage("/login").failureUrl("/loginError")
		  .usernameParameter("emailId").passwordParameter("password")
		.and()
			.logout().logoutSuccessUrl("/logout")
		.and()
		  .exceptionHandling().accessDeniedPage("/accessDenied")
		.and()
		  .csrf().ignoringAntMatchers("/addcategory","/editcategory", "addsubcategory", "/addsupplier","/editsupplier", "/addproduct","/editproduct","/validate","/register");
	}
	
	 @Bean(name="myAuthenticationManager")
	 @Override
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	     return super.authenticationManagerBean();
	 }
}