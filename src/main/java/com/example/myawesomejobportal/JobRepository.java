package com.example.myawesomejobportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myawesomejobportal.entities.JobListing;

public interface JobRepository extends JpaRepository<JobListing, Long> {
    // You can add custom queries if needed
}
