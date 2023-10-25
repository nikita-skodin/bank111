package com.bank.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    @CollectionTable(name = "events_images")
    @ElementCollection
    @Builder.Default
    private List<String> images = new ArrayList<>();

    @Column(name = "date_of_publishment")
    @Builder.Default
    private Instant dateOfPublish = Instant.now();

    @Column(name = "date_of_event")
    private Instant dateOfEvent;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "total_stars")
    private Integer totalStars;

    @Column(name = "review_counter")
    private Integer reviewCounter;

    @Column(name = "rating")
    private double rating;

    @OneToMany(mappedBy = "event")
    @Builder.Default
    private List<ReviewForEvent> review = new ArrayList<>();

    @NotNull
    @Column(name="contact_number")
    // TODO
    private String contactNumber;

    @NotNull
    @Column(name="working_hours")
    private String workingHours;
}