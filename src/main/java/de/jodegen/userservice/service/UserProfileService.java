package de.jodegen.userservice.service;

import de.jodegen.userservice.exception.UserNotFoundException;
import de.jodegen.userservice.model.UserProfile;
import de.jodegen.userservice.repository.UserProfileRepository;
import de.jodegen.userservice.rest.dto.UserProfileUpdateDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfile findById(long userId) {
        return userProfileRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public UserProfile save(@NonNull UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile updateUserProfile(long userId, @NonNull UserProfileUpdateDto updateDto) {
        log.info("Updating user profile for userId: {}", userId);
        UserProfile existingProfile = findById(userId);
        existingProfile.setFirstName(updateDto.getFirstName());
        existingProfile.setLastName(updateDto.getLastName());
        existingProfile.setProfilePictureUrl(updateDto.getProfilePictureUrl());
        return save(existingProfile);
    }
}

