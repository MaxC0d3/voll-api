package med.voll.api.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import med.voll.api.domain.users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

  @Value("${api.security.jwt.secret}")
  private String apiSecret;

  public String generateToken(User user){
    try{
      Algorithm algorithm = Algorithm.HMAC256(apiSecret);
      return JWT.create()
        .withIssuer("voll_med")
        .withSubject(user.getLogin())
        .withClaim("id", user.getId())
        .withExpiresAt(getExpirationDate())
        .sign(algorithm);
    }catch (JWTCreationException exception){
      throw new RuntimeException();
    }
  }

  public String getSubject(String token) {

    if (token == null) {
      throw new RuntimeException();
    }

    DecodedJWT verifier;

    try {
      Algorithm algorithm = Algorithm.HMAC256(apiSecret);
      verifier = JWT.require(algorithm)
        .withIssuer("voll_med")
        .build()
        .verify(token);

      if (verifier.getExpiresAt().toInstant().isBefore(Instant.now()) && verifier.getSubject() == null) {
        throw new RuntimeException();
      }

      verifier.getSubject();

    } catch (JWTVerificationException exception) {
      throw new RuntimeException();
    }

    return verifier.getSubject();
  }

  private Instant getExpirationDate(){
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }

}
