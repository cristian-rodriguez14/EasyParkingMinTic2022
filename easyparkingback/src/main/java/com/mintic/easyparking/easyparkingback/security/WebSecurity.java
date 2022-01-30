package com.mintic.easyparking.easyparkingback.security;

import com.mintic.easyparking.easyparkingback.services.UsuarioServiceInterface;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final UsuarioServiceInterface usuarioService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UsuarioServiceInterface usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/usuario/").permitAll()
                .antMatchers(HttpMethod.POST, "/usuario/newCliente").permitAll()
                .antMatchers(HttpMethod.POST, "/usuario/forgot_password").permitAll()
                .antMatchers(HttpMethod.PUT, "/usuario/reset_password/{token}").permitAll()
                .antMatchers(HttpMethod.GET, "/usuario/allTiposi").permitAll()
//                .antMatchers(HttpMethod.POST, "/usuario/newEmpleado").hasRole("1")
//                .antMatchers(HttpMethod.GET, "/usuario/allUsuarios").hasAnyRole("2", "1")
//                .antMatchers(HttpMethod.PUT, "/usuario/delete").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/usuario/suscripcion").hasAnyRole("OPERARIO", "ADMIN")
//                .antMatchers(HttpMethod.POST, "/reserva/newReserva").hasAnyRole("OPERARIO", "ADMIN")
//                .antMatchers(HttpMethod.GET, "/reserva/allReservas").hasAnyRole("OPERARIO", "ADMIN")
//                .antMatchers(HttpMethod.GET, "/reserva/allReservasUsuario").hasAnyRole("CLIENTE")
//                .antMatchers(HttpMethod.POST, "/vehiculo/newVehiculo").hasAnyRole("OPERARIO", "ADMIN")
//                .antMatchers(HttpMethod.GET, "/vehiculo/allVehiculos").hasAnyRole("OPERARIO", "ADMIN")
//                .antMatchers(HttpMethod.POST, "/factura/newFactura").hasAnyRole("OPERARIO", "ADMIN")
//                .antMatchers(HttpMethod.GET, "/factura/allFacturas").hasAnyRole("OPERARIO", "ADMIN")
//                .antMatchers(HttpMethod.GET, "/factura/monthTrace").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/factura/semestralTrace").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/factura/anualTrace").hasAnyRole("ADMIN")
                .anyRequest().authenticated().and().addFilter(getAuthenticationFilter())
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(bCryptPasswordEncoder);
    }
    
    public AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());

        filter.setFilterProcessesUrl("/usuario/login");

        return filter;
    }
}
