package com.example.myawesomejobportal.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.example.myawesomejobportal.entities.User;
import com.example.myawesomejobportal.entities.JobListing;
import com.example.myawesomejobportal.repositories.UserRepository;
import com.example.myawesomejobportal.repositories.JobRepository;

import java.util.*;

@RestController
@RequestMapping("/api")
// Updated CrossOrigin annotation to use 'origins' instead of 'allowedOriginPatterns'
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    // Test endpoint
    @GetMapping("")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(Map.of("message", "This is a test message"));
    }

    // Register user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> data) {
        String email = data.get("email");
        String password = data.get("password");

        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email is required"));
        }
        if (password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Password is required"));
        }

        User existing = userRepository.findByEmail(email);
        if (existing != null) {
            return ResponseEntity.badRequest().body(Map.of("message", "User already exists"));
        }

        User user = new User(email, password);
        userRepository.save(user);
        return ResponseEntity.ok(Map.of("message", "User with email " + email + " created successfully"));
    }

    // Fake authentication endpoint
    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
        String email = data.get("email");
        String password = data.get("password");

        if (email == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email and password are required"));
        }

        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // In a real app, you'd return a JWT or session token
            return ResponseEntity.ok(Map.of("success", true, "message", "Logged in successfully"));
        }
        return ResponseEntity.status(401).body(Map.of("success", false, "message", "Invalid credentials"));
    }

    // Profile endpoint (secured)
    @GetMapping("/profile")
    public ResponseEntity<?> profile(Authentication authentication) {
        return ResponseEntity.ok(Map.of("message", "Profile endpoint (secured)", "user", authentication.getName()));
    }

    // Create a job listing
    @PostMapping("/joblisting")
    public ResponseEntity<?> createJoblisting(@RequestBody Map<String, String> data) {
        String title = data.get("title");
        String description = data.get("description");

        if (title == null || title.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Title is required"));
        }
        if (description == null || description.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Description is required"));
        }

        JobListing job = new JobListing(title, description, false);
        jobRepository.save(job);
        return ResponseEntity.ok(Map.of("message", "Job posted successfully"));
    }

    // Get all job listings
    @GetMapping("/joblistings")
    public ResponseEntity<?> getAllJoblistings() {
        List<JobListing> jobs = jobRepository.findAll();
        return ResponseEntity.ok(jobs);
    }

    // Approve a job listing
    @PutMapping("/joblistings/{id}/approve")
    public ResponseEntity<?> approveJob(@PathVariable Long id) {
        Optional<JobListing> optionalJob = jobRepository.findById(id);
        if (optionalJob.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("message", "Job not found"));
        }
        JobListing job = optionalJob.get();
        job.setApproved(true);
        jobRepository.save(job);
        return ResponseEntity.ok(Map.of("message", "Job approved successfully"));
    }
}
