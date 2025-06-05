package de.jodegen.userservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {

    @Id
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
