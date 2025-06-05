package de.jodegen.userservice.listener;

import de.jodegen.auction.event.UserAccountCreatedEvent;
import de.jodegen.userservice.command.CreateUserProfileCommand;
import de.jodegen.userservice.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAccountCreatedEventListener {

    private final UserProfileService userProfileService;

    @KafkaListener(topics = "user-account-created", groupId = "user-account-events-group")
    public void handleUserAccountCreated(UserAccountCreatedEvent event) {
        log.info("Received user account created event: {}", event);

        var command = CreateUserProfileCommand.builder()
                .userId(event.getUserId())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .build();

        userProfileService.createUserProfile(command);
        log.info("Created user profile for user {}", event.getUserId());
    }
}
