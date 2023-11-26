package com.faqcodes.challenge.adapters.security;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTSecurityToken implements SecurityToken {

  @Override
  public String generateToken(Map<String, Object> claims, String subject) {
    final var TOKEN_EXPIRATION = 5 * 60 * 60 * 1000;
    final var secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    return Jwts.builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
        .signWith(secretKey)
        .compact();
  }

}
