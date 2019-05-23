package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests().mvcMatchers("/").permitAll()
                .mvcMatchers("/*").permitAll()
                .mvcMatchers("/h2-console/*").permitAll()
                .mvcMatchers("/dagmenu/**").permitAll()
                .mvcMatchers("/dagmenu/change/*").permitAll()
                .mvcMatchers("/weekmenu/*").permitAll()
                .mvcMatchers("/css/**", "/js/**").permitAll()
                .mvcMatchers("/weekmenu/angular").permitAll()
                .mvcMatchers("/weekmenus/*").permitAll()
                .mvcMatchers("/gerechten/").hasAnyRole("USER","ADMIN")
                .mvcMatchers("/gerechten/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().sameOrigin();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER").and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");

    }
}
