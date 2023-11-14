package dev.naman.userservicetestfinal.controllers;

import dev.naman.userservicetestfinal.dtos.*;
import dev.naman.userservicetestfinal.exceptions.ApplicationException;
import dev.naman.userservicetestfinal.models.Session;
import dev.naman.userservicetestfinal.models.SessionStatus;
import dev.naman.userservicetestfinal.models.User;
import dev.naman.userservicetestfinal.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto request) {
        return authService.login(request.getEmail(), request.getPassword());
//        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto request) {
        return authService.logout(request.getToken(), request.getUserId());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto request) {
        UserDto userDto = authService.signUp(request.getEmail(), request.getPassword());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<SessionStatus> validateToken(@RequestBody ValidateTokenRequestDto request) {

        try{
            SessionStatus sessionStatus = authService.validate(request.getToken(), request.getUserId());
            return new ResponseEntity<>(sessionStatus, HttpStatus.OK);
        }
        catch(Exception e){
            String msg = e.getMessage();
            //throw new ApplicationException(msg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,msg);
        }
    }

}
