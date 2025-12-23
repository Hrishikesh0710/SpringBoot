package com.gop.GangsOfPav.controller;

import com.gop.GangsOfPav.dto.LoginRequestDTO;
import com.gop.GangsOfPav.dto.LoginResponseDTO;
import com.gop.GangsOfPav.dto.RegisterRequestDTO;
import com.gop.GangsOfPav.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequestDTO dto) {
        authService.register(dto);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public LoginResponseDTO login(
            @Valid @RequestBody LoginRequestDTO request) {

        return authService.login(request);
    }
}
