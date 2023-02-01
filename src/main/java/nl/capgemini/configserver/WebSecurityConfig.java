package nl.capgemini.configserver;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorizer) -> {
            try {
                authorizer
                        .anyRequest()
                        .permitAll()
                        .and()
                        .csrf()
                        .disable();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).httpBasic(withDefaults());
        return http.build();
    }
}
