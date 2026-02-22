package com.vuespring.service;

import com.vuespring.dto.AuthResponse;
import com.vuespring.dto.ForgotPasswordRequest;
import com.vuespring.dto.LoginRequest;
import com.vuespring.dto.RegisterRequest;
import com.vuespring.exception.UnauthorizedException;
import com.vuespring.model.Account;
import com.vuespring.model.User;
import com.vuespring.repository.AccountRepository;
import com.vuespring.repository.UserRepository;
import com.vuespring.security.JwtTokenProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private static final String[] CHINESE_ZODIAC = {
        "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake",
        "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig"
    };
    private static final Random random = new Random();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AccountRepository accountRepository;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        User user = new User(
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getFullName()
        );

        user = userRepository.save(user);

        // No registration code - create a new account for this user and make them an admin
        String zodiacAnimal = CHINESE_ZODIAC[random.nextInt(CHINESE_ZODIAC.length)];
        Account account = new Account(zodiacAnimal, "green");
        account = accountRepository.save(account);
        user.setRole(User.UserRole.ADMIN);
    

        // Set the account on the user
        user.setAccount(account);
        user = userRepository.save(user);

        String token = jwtTokenProvider.generateToken(user.getUsername(), user.getId());
        return new AuthResponse(token, user);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UnauthorizedException("The login attempt failed, try again."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("The login attempt failed, try again.");
        }

        String token = jwtTokenProvider.generateToken(user.getUsername(), user.getId());
        return new AuthResponse(token, user);
    }

    public String forgotPassword(ForgotPasswordRequest request) {
        if (request.getUsername() == null && request.getEmail() == null) {
            throw new IllegalArgumentException("Either username or email must be provided");
        }
        
        User user = null;
        
        if (request.getUsername() != null) {
            user = userRepository.findByUsername(request.getUsername())
                    .orElse(null);
        }
        
        if (user == null && request.getEmail() != null) {
            user = userRepository.findByEmail(request.getEmail())
                    .orElse(null);
        }
        
        if (user == null) {
            // Log the failed attempt but don't leak that the user doesn't exist
            logger.warn("Password reset attempt for non-existent user. Username: {}, Email: {}", 
                       request.getUsername(), request.getEmail());
            // Return generic success message to prevent user enumeration
            return "If an account exists with the provided information, password reset instructions have been sent.";
        }
        
        // TODO: In a real application, you would:
        // 1. Generate a password reset token
        // 2. Store the token with expiration time
        // 3. Send an email to the user with a reset link
        // For now, we'll just return a success message
        
        logger.info("Password reset requested for user: {}", user.getUsername());
        return "If an account exists with the provided information, password reset instructions have been sent.";
    }
}
