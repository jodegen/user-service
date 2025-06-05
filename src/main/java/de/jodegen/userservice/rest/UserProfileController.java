package de.jodegen.userservice.rest;

import de.jodegen.userservice.model.*;
import de.jodegen.userservice.rest.dto.UserProfileUpdateDto;
import de.jodegen.userservice.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/user-profile")
public class UserProfileController {

    private final SecurityService securityService;
    private final UserProfileService userProfileService;

    @PostMapping(path = "/update")
    public ResponseEntity<UserProfile> updateProfile(@RequestBody UserProfileUpdateDto updateDto) {
        JwtUserDetails jwtUserDetails = securityService.assertLoggedInUserAccount();
        UserProfile userProfile = userProfileService.updateUserProfile(jwtUserDetails.getUserId(), updateDto);
        return ResponseEntity.ok(userProfile);
    }
}
