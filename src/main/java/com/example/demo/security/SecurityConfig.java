/*package com.example.demo.security;

import com.example.demo.security.filter.CustomAuthenticationFilter;
import com.example.demo.security.filter.CustomAuthorisationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//@Configuration
//@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();// A REVOIR
       CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(super.authenticationManager());
       // Define authentication url
       customAuthenticationFilter.setFilterProcessesUrl("/api/login");
       // Aucune session ne sera créé ou bien utilisée par Spring Security
       // We use authentication by token
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

       http.authorizeRequests().antMatchers( "/api/login/**","/api/token/refresh/**").permitAll();
       http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");
       http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/user/save/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");
       http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/role/save/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");
       http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/role/addtouser/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");

       http.addFilterBefore(new CustomAuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
       http.addFilter(customAuthenticationFilter);



    }
}
*/


