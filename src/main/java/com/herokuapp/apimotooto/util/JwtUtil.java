package com.herokuapp.apimotooto.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.herokuapp.apimotooto.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class JwtUtil {

    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    @Value ("${authentication.jwt.secret}")
    private String secret;

    public String createToken(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 6);

        return JWT.create()
                  .withClaim(ID, user.getId())
                  .withClaim(EMAIL, user.getEmail())
                  .withClaim(USERNAME, user.getUsername())
                  .withIssuedAt(new Date())
                  .sign(Algorithm.HMAC512(secret));
    }
}
