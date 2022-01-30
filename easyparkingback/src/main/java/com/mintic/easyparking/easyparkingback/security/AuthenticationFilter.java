package com.mintic.easyparking.easyparkingback.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintic.easyparking.easyparkingback.SpringApplicationContext;
import com.mintic.easyparking.easyparkingback.models.requests.UsuarioLoginRequestModel;
import com.mintic.easyparking.easyparkingback.services.UsuarioServiceInterface;
import com.mintic.easyparking.easyparkingback.shared.dto.AccesoDto;
import com.mintic.easyparking.easyparkingback.shared.dto.UsuarioDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            UsuarioLoginRequestModel usuarioModel = new ObjectMapper().readValue(request.getInputStream(),
                    UsuarioLoginRequestModel.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioModel.getUsername(),
                    usuarioModel.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authentication) throws IOException, ServletException {
        String username = ((User) authentication.getPrincipal()).getUsername();

        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_DATE))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret()).compact();

//        UsuarioServiceInterface usuarioService = (UsuarioServiceInterface) SpringApplicationContext.getBean("usuarioService");
//        AccesoDto accesoDto = usuarioService.getUsuarioLog(username);

        response.addHeader("Access-Control-Expose-Headers", "Authorization");
//        response.addHeader("UsuarioId", Long.toString(accesoDto.getAccesoId()));
        
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);

    }
}
