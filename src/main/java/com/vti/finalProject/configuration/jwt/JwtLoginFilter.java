package com.vti.finalProject.configuration.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
    private final JwtEncoder jwtEncoder;
    private final ObjectMapper objectMapper;

    public JwtLoginFilter(AuthenticationManager authenticationManager, JwtEncoder jwtEncoder) {
        this(authenticationManager, jwtEncoder, new ObjectMapper());
    }

    public JwtLoginFilter(AuthenticationManager authenticationManager, JwtEncoder jwtEncoder, ObjectMapper objectMapper) {
        super(new AntPathRequestMatcher("/api/v1/auth/login"), authenticationManager);
        this.jwtEncoder = jwtEncoder;
        this.objectMapper = objectMapper;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Map<String, String> loginRequest = objectMapper.readValue(request.getInputStream(), Map.class);
            var email = loginRequest.get("email");
            var password = loginRequest.get("password");
            var authentication = UsernamePasswordAuthenticationToken.unauthenticated(email, password);
            return getAuthenticationManager().authenticate(authentication);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain chain, Authentication authResult
    ) throws IOException {
        var now = Instant.now();
        var scope = authResult.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        var claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(18000L))
                .subject(authResult.getName())
                .claim("scope", scope)
                .build();
        var token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        response.getWriter().write(token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Your email or password is incorrect. Please try again.");
    }
}
