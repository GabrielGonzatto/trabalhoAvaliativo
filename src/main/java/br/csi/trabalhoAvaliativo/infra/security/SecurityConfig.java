package br.csi.trabalhoAvaliativo.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(crsf->crsf.disable())
                .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth").permitAll()
                        .requestMatchers(HttpMethod.POST,"/usuario").permitAll()
                        .requestMatchers(HttpMethod.GET,"/usuario/listaUsuario").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.GET,"/ordemservico").hasAnyRole("MECHANIC","CLIENT")
                        .requestMatchers(HttpMethod.POST,"/ordemservico/cadastrarOrdemServico").hasAnyRole("MECHANIC","CLIENT")
                        .requestMatchers(HttpMethod.GET,"/ordemservico/ordemAtiva").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.GET,"/ordemservico/ordemInativa").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.GET,"/ordemservico/ordemAtiva").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.GET,"/ordemservico/{id}").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.DELETE,"/ordemservico/{id}").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.PUT,"/ordemservico/encerrarOrdem").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.GET,"/produtoCusto").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.GET,"/custos").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.POST,"/custos").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.GET,"/mecanico").hasRole("MECHANIC")
                        .requestMatchers(HttpMethod.POST,"/mecanico").hasRole("MECHANIC")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
