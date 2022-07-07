//
// This class is responsible for the security configuration of the application.
//
// THIS FILE IS GENERATED. DO NOT EDIT!!
//

package ${domain.namespace};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ${domain.namespace}.jwt.AuthEntryPointJwt;
import ${domain.namespace}.jwt.AuthTokenFilter;
import ${domain.namespace}.workfactor.BcCryptWorkFactorService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final BcCryptWorkFactorService bcCryptWorkFactorService;
    private final PersistentUserDetailsService persistentUserDetailsService;
    private final PersistentUserDetailsPasswordService persistentUserDetailsPasswordService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    public SecurityConfig(
          BcCryptWorkFactorService bcCryptWorkFactorService,
          PersistentUserDetailsService persistentUserDetailsService,
          PersistentUserDetailsPasswordService persistentUserDetailsPasswordService) {
        this.bcCryptWorkFactorService = bcCryptWorkFactorService;
        this.persistentUserDetailsService = persistentUserDetailsService;
        this.persistentUserDetailsPasswordService = persistentUserDetailsPasswordService;
    }

$[ let authUrlPrefix = ((space|domain:APIPath).domain.tagValue("url:prefix:auth")) ]
$[ let staticUrlPrefix = ((space|domain:APIPath).domain.tagValue("url:prefix:static")) ]
$[ let apiUrlPrefix = ((space|domain:APIPath).domain.tagValue("url:prefix:api")) ]

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().authorizeRequests().anyRequest().permitAll();

        httpSecurity.csrf().disable() // cors().and().
                .authorizeRequests()
                .antMatchers(
$[if space.domain("Security").hasTag("feature:invite")]
                        "${authUrlPrefix}/invite_accept**",
$[else]
                        "${authUrlPrefix}/signup**",
$[/if]
                        "${authUrlPrefix}/login**",
                        "${apiUrlPrefix}/login**",
                        "${staticUrlPrefix}/js/**",
                        "${staticUrlPrefix}/css/**",
                        "${staticUrlPrefix}/img/**",
                        "${staticUrlPrefix}/webjars/**",
                        "${staticUrlPrefix}/swagger-ui.html",
                        "${staticUrlPrefix}/swagger-ui/**",
                        "${staticUrlPrefix}/public/**",
                        "${staticUrlPrefix}/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("token")
                .logoutRequestMatcher(new AntPathRequestMatcher("${authUrlPrefix}/logout"))
                .logoutSuccessUrl("${authUrlPrefix}/login?logout")
                .permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.headers().frameOptions().disable();
    }

    @Bean("daoAuthenticationProvider")
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsPasswordService(this.persistentUserDetailsPasswordService);
        provider.setUserDetailsService(this.persistentUserDetailsService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(bcCryptWorkFactorService.calculateStrength());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
}
