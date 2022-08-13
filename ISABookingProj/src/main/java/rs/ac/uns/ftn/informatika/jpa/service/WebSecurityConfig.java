package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import rs.ac.uns.ftn.informatika.jpa.security.RestAuthenticationEntryPoint;
import rs.ac.uns.ftn.informatika.jpa.security.TokenAuthenticationFilter;
import rs.ac.uns.ftn.informatika.jpa.security.TokenUtil;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomUserDetailsService jwtUserDetailsService;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    private TokenUtil tokenUtils;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

                .authorizeRequests().antMatchers("/api/users/register").permitAll()

                .anyRequest().authenticated().and()

                .formLogin().loginPage("/login").permitAll().and()

                .logout().permitAll().and()

                .cors().and()

                .httpBasic().and()

                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService), BasicAuthenticationFilter.class);
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, "/api/login");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/users");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/houses");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/mail");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/availabilities");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/v1/image-upload");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/fishingReservations/fishingClassReservations");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/fishing/classes");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/fishingReservations/fishingClassReviews");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/loyality");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/users");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/houses");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/houses/{id}");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/fishing/classes");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/fishingImages/fishingClassImages");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/fishingImages/{fishingClassImages}");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/fishingImages/get/{fishingClassImages}");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/fishingReservations/fishingClassReservations");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/grade/bySubject/{id}");
       // web.ignoring().antMatchers(HttpMethod.GET, "/api/currentUser");
        web.ignoring().antMatchers(HttpMethod.PUT, "/api/users");
        web.ignoring().antMatchers(HttpMethod.PUT, "/api/users/{id}");
        web.ignoring().antMatchers(HttpMethod.PUT, "/api/houses");
        web.ignoring().antMatchers(HttpMethod.PUT, "/api/loyality");
        web.ignoring().antMatchers(HttpMethod.DELETE, "/api/users/{id}");
        web.ignoring().antMatchers(HttpMethod.DELETE, "/api/houses/{id}");
        web.ignoring().antMatchers(HttpMethod.DELETE, "/api/fishing/classes/{id}");
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}