package com.rsproject.your_punchbread.config;

import com.rsproject.your_punchbread.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import com.rsproject.your_punchbread.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Fix 1: Check for "shinn" instead of "admin"
        if (userRepository.findByUsername("shinn").isEmpty()) {
            User admin = new User("shinn", passwordEncoder.encode("admin123"), "ROLE_ADMIN");
            userRepository.save(admin);
            System.out.println("Admin account created.");
        }

        // Fix 2: Check for "misu" instead of "girlfriend"
        if (userRepository.findByUsername("misu").isEmpty()) {
            User gf = new User("misu", passwordEncoder.encode("misu026469"), "ROLE_USER");
            userRepository.save(gf);
            System.out.println("Girlfriend account created.");
        }
    }
}
