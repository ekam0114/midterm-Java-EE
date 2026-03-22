package com.example.University.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workshops")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 80, message = "Title must be between 5 and 80 characters")
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank(message = "Location is required")
    @Column(nullable = false)
    private String location;

    @NotNull(message = "Start date/time is required")
    @Future(message = "Start date/time must be in the future")
    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime startDatetime;

    @Min(value = 1, message = "Total seats must be at least 1")
    @Column(name = "total_seats", nullable = false)
    private int totalSeats;

    @Column(name = "seats_remaining", nullable = false)
    private int seatsRemaining;

    // "ACTIVE" or "CANCELLED"
    @Column(nullable = false)
    private String status = "ACTIVE";

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Registration> registrations = new ArrayList<>();

    public Workshop() {}

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = "ACTIVE";
        }
        this.seatsRemaining = this.totalSeats;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getStartDatetime() { return startDatetime; }
    public void setStartDatetime(LocalDateTime startDatetime) { this.startDatetime = startDatetime; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

    public int getSeatsRemaining() { return seatsRemaining; }
    public void setSeatsRemaining(int seatsRemaining) { this.seatsRemaining = seatsRemaining; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Registration> getRegistrations() { return registrations; }
    public void setRegistrations(List<Registration> registrations) { this.registrations = registrations; }
}
