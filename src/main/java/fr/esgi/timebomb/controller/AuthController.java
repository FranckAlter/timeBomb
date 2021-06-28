package fr.esgi.timebomb.controller;

import fr.esgi.timebomb.dao.AccountRepository;
import fr.esgi.timebomb.domain.Player;
import fr.esgi.timebomb.dto.LoginDTO;
import fr.esgi.timebomb.security.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
public class AuthController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(TokenProvider tokenProvider,
                          AuthenticationManagerBuilder authenticationManager,
                          AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(("/login"))
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);

        String token = tokenProvider.createToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(AUTHORIZATION, "Bearer " + token);
        httpHeaders.add(AUTHORIZATION, token);

        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
