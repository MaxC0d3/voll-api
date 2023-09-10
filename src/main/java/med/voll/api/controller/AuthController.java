package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.users.User;
import med.voll.api.domain.users.records.DataAuthUser;
import med.voll.api.infrastructure.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private TokenService tokenService;

  @PostMapping
  private ResponseEntity<?> login(@RequestBody @Valid DataAuthUser dataAuthUser) {
    Authentication authToken = new UsernamePasswordAuthenticationToken(dataAuthUser.login(), dataAuthUser.password());
    var authUser = authenticationManager.authenticate(authToken);

    var JWTtoken = tokenService.generateToken((User) authUser.getPrincipal());

    return ResponseEntity.ok(JWTtoken);
  }

}
