package de.jodegen.userservice.command;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserProfileCommand {

    @NonNull
    private Long userId;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
