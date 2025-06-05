package de.jodegen.userservice.rest.dto;

import lombok.*;

@Getter
@Setter
public class UserProfileUpdateDto {
    private String firstName;
    private String lastName;
    private String profilePictureUrl;
}
