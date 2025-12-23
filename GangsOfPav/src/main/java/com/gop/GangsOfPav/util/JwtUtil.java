package com.gop.GangsOfPav.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // ✅ Generate JWT
    public String generateToken(Long userId, String email) {
        return Jwts.builder()
                .setSubject(email)               // ✅ EMAIL AS SUBJECT
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    // ✅ Parse claims
    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // ✅ Extract email (SUBJECT)
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // (optional, if needed later)
    public Long extractUserId(String token) {
        return extractClaims(token).get("userId", Long.class);
    }
}
