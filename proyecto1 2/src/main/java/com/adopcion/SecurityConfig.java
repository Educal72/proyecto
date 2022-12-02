
package com.adopcion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author DYL4N16199
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override 
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .antMatchers("/adopcion/nuevo", "/adopcion/guardar",
                        "/adopcion/modificar/{idAnimal}","/adopcion/eliminar/{idAnimal}",
                        
                        "/productos/nuevo", "/productos/guardar",
                        "/productos/modificar/{idProducto}","/productos/eliminar/{idProducto}"
                                                                     
                        )
                .hasRole("ADMIN")
        .antMatchers("/carrito/ver",
                
                        "/cuenta"
                        
                        
                                                                    
                        )
                .hasAnyRole("ADMIN","USER")
                
               .antMatchers("/","/adopcion/ver",
                        "/productos/ver","/productos/buscar/alimento",
                        "/productos/buscar/correas",
                        "/productos/buscar/juguetes","/productos/buscar/higiene")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
    
    
    


}