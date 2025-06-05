package de.jodegen.userservice.listener;

import de.jodegen.auction.event.UserAccountCreatedEvent;
import de.jodegen.userservice.model.UserProfile;
import de.jodegen.userservice.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAccountCreatedEventListener {

    private final UserProfileService userProfileService;

    @KafkaListener(topics = "user-account-created", groupId = "user-account-events-group")
    public void handleUserAccountCreated(UserAccountCreatedEvent event) {
        log.info("Received user account created event: {}", event);

        UserProfile userProfile = new UserProfile();
        userProfile.setId(event.getUserId());
        userProfile.setFirstName(event.getFirstName());
        userProfile.setLastName(event.getLastName());
        userProfile.setCreatedAt(LocalDateTime.now());
        userProfileService.save(userProfile);
        log.info("Created user profile: {}", userProfile);
    }
}
