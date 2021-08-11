package com.herokuapp.apimotooto.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.herokuapp.apimotooto.model.User;
import com.herokuapp.apimotooto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.herokuapp.apimotooto.util.JwtUtil.EMAIL;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    @Value ("${authentication.jwt.secret}")
    private String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorization == null || authorization.isEmpty()) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String email = getEmail(authorization);

        User user = userRepository.findUserByEmail(email)
                                  .orElseThrow(
                                          () -> new UsernameNotFoundException(
                                                  "Username with email " + email + " does not exist"));

        UsernamePasswordAuthenticationToken token = getToken(user);
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
        SecurityContextHolder.getContext().setAuthentication(token);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getEmail(String authorization) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(secret)).build();
        DecodedJWT verify = jwtVerifier.verify(authorization.substring(7));

        return verify.getClaim(EMAIL).asString();
    }

    private UsernamePasswordAuthenticationToken getToken(User user) {
        return new UsernamePasswordAuthenticationToken(
                user,
                user.getEmail(),
                user.getAuthorities()
        );
    }
}
