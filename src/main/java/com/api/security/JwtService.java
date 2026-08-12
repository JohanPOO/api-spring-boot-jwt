package com.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String key;

    @Value("${jwt.expiration}")
    private long expiration;



    public Key getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    //Generar Token
    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey())
                .compact();
    }

    //Extraer el username del token
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    //Obtener un dato especifico del token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Obtener todos los datos del token
    public Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    //Validar Token
    public boolean isValidToken(String token, String username){
        String usernameFromToken = extractUsername(token);

        return usernameFromToken.equals(username) && !isTokenExpired(token);
    }

    //Comprobar si expiro el token
    public boolean isTokenExpired(String token){

        Date expirationDate = extractClaim(token, Claims::getExpiration);

        return expirationDate.before(new Date());
    }

}
