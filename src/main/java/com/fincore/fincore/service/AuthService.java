package com.fincore.fincore.service;

import com.fincore.fincore.dto.auth.AuthResponse;
import com.fincore.fincore.dto.auth.LoginRequest;
import com.fincore.fincore.dto.auth.RegisterRequest;
import com.fincore.fincore.entity.Role;
import com.fincore.fincore.entity.User;
import com.fincore.fincore.repository.UserRepository;
import com.fincore.fincore.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder().firstname(registerRequest.getFirstname()).lastname(registerRequest.getLastname()).email(registerRequest.getEmail()).password(passwordEncoder.encode(registerRequest.getPassword())).role(Role.USER).build();

        User savedUser = userRepository.save(user);

        String token = jwtService.generateToken(savedUser);
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);

        return new AuthResponse(token);
    };
}