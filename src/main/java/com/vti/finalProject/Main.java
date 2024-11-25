package com.vti.finalProject;

import com.vti.finalProject.entity.Role;
import com.vti.finalProject.entity.User;
import com.vti.finalProject.repository.RoleRepository;
import com.vti.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class Main {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner initializeAdminUser() {
        return args -> {
            Role role = roleRepository.findByType(Role.Type.ADMIN);
            if (role == null) {
                role = new Role();
                role.setType(Role.Type.ADMIN);
                role = roleRepository.save(role);
            }

            String adminEmail = "admin@vti.com.vn";
            User adminUser = userRepository.findByEmail(adminEmail);

            if (adminUser == null) {
                adminUser = new User();
                adminUser.setEmail(adminEmail);
                adminUser.setFullName("Administrator");
                adminUser.setPassword(passwordEncoder.encode("Admin@123"));

                HashSet<Role> roles = new HashSet<>();
                roles.add(role);
                adminUser.setRoles(roles);

                userRepository.save(adminUser);

                System.out.println("Admin user created successfully!");
                System.out.println("Email: " + adminEmail);
                System.out.println("Password: Admin@123");
            } else {
                System.out.println("Admin user already exists!");
            }
        };
    }
}