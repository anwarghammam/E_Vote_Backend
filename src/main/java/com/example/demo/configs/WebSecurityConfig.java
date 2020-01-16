package com.example.demo.configs;

import com.example.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsService userDetailsService = mongoUserDetails();
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable().csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/api/auth/login").permitAll()
                .antMatchers("/api/auth/register").permitAll()
                .antMatchers("/vote/add").permitAll()
                .antMatchers("/vote/activate").permitAll()
                .antMatchers("/api/vote/candidate").permitAll()
                .antMatchers("/api/vote/vote").permitAll()
                .antMatchers("/api/vote/accueilUser").permitAll()
                .antMatchers("/api/vote/createVote").permitAll()
                .antMatchers("/api/vote/verfiSatusVote").permitAll()
                .antMatchers("/api/vote/UserVoteVerif").permitAll()
                .antMatchers("/api/vote/loadResultatVote").permitAll()
                .antMatchers("/api/vote/SortResulatat").permitAll()
                .antMatchers("/api/vote/createResultat").permitAll()
                .antMatchers("/api/vote/statistiqueCalcul").permitAll()
                .antMatchers("/api/vote/totalFemmes").permitAll()
                .antMatchers("/api/vote/totalHommes").permitAll()
                .antMatchers("/api/vote/totalAdultes").permitAll()
                .antMatchers("/api/vote/totalJeunes").permitAll()
                .antMatchers("/api/vote/totalVieux").permitAll()
                .antMatchers("/api/vote/loadStatistique").permitAll()

                .antMatchers("/api/vote/detailsStatistique").permitAll()
                .antMatchers("/api/vote/totalParticipents").permitAll()

                .antMatchers("/api/vote/follow").permitAll()

                .antMatchers("/vote/*").permitAll()
                .antMatchers("/api/candidate/*").permitAll()
                .antMatchers("/api/candidate/allcondidates").permitAll()
                .antMatchers("/api/candidate/allfuturdebates").permitAll()
                .antMatchers("/api/candidate/addprogram/*").permitAll()
                .antMatchers("/api/candidate/addvideostocandidat/*").permitAll()

                .antMatchers("/videos/*").permitAll()
                .antMatchers("/videos/stream/*").permitAll()
                .antMatchers("/videos/add/*").authenticated()

                .antMatchers("api/auth/allusers").hasAuthority("ADMIN").anyRequest().authenticated().and().csrf()

                .disable().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint()).and()
                .apply(new JwtConfigurer(jwtTokenProvider));
        http.cors();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized");
    }

    @Bean
    public UserDetailsService mongoUserDetails() {
        return new CustomUserDetailsService();
    }
}