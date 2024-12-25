package dev.lubna.JA.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class JaSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpS) throws Exception {

        return  httpS.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/check").permitAll()
//                        .requestMatchers("/user").authenticated()
                        .requestMatchers("/user/create").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();

//        return  null;
    }
}
