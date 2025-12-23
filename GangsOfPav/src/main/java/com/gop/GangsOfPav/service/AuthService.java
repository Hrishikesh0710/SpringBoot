package com.gop.GangsOfPav.service;

import com.gop.GangsOfPav.dto.LoginRequestDTO;
import com.gop.GangsOfPav.dto.LoginResponseDTO;
import com.gop.GangsOfPav.dto.RegisterRequestDTO;
import com.gop.GangsOfPav.entity.User;
import com.gop.GangsOfPav.exception.BadRequestException;
import com.gop.GangsOfPav.repository.UserRepository;
import com.gop.GangsOfPav.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ✅ REGISTER
    public void register(RegisterRequestDTO dto) {

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new BadRequestException("Email already registered");
        }

        User user = new User(
                dto.getName(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword())
        );

        userRepository.save(user);
    }

    // ✅ LOGIN
    public LoginResponseDTO login(LoginRequestDTO request) {

        String email = request.getEmail().toLowerCase();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new BadRequestException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getId(), user.getEmail());

        return new LoginResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                token
        );
    }
}
