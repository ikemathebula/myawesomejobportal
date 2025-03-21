package com.example.myawesomejobportal.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class JobListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean approved;

    // No-argument constructor
    public JobListing() {}

    // Constructor matching usage in ApiController
    public JobListing(String title, String description, boolean approved) {
        this.title = title;
        this.description = description;
        this.approved = approved;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) { this.description = description; }

    public boolean isApproved() {
        return approved;
    }
    public void setApproved(boolean approved) { this.approved = approved; }
}
