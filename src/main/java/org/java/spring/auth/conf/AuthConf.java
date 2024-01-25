package org.java.spring.auth.conf;

import org.java.spring.auth.db.serv.UserService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AuthConf {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
	        .requestMatchers("/**").permitAll()
	        .and().formLogin()
	        .and().logout()
	    ;
		
		return http.build();
	}
	
	@Bean
    UserDetailsService userDetailsService() {
	    return new UserService();
	}
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
	
	@Bean
    DaoAuthenticationProvider authenticationProvider() {
      
    	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
   
    	authProvider.setUserDetailsService(userDetailsService());
    	authProvider.setPasswordEncoder(passwordEncoder());
   
    	return authProvider;
    }
	
	@Bean
    FilterRegistrationBean<CorsFilter> getCorsSettings() {
		
        final CorsConfiguration config = new CorsConfiguration();
        
        // OPTIONS
//        config.setAllowCredentials(true);
        
        config.addAllowedOrigin("http://localhost:5173"); // DEVELOP FE SERVER
        
        // HEADERS
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("X-XSRF-TOKEN");
        config.addAllowedHeader("Accept");
        
        // METHODS
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.DELETE);
        
        // SET CONFIG ON PATHS
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        
        final FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        
        return bean;
    }
}