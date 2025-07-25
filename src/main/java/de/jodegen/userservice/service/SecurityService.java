package de.jodegen.userservice.service;

import de.jodegen.userservice.model.JwtUserDetails;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecurityService {

    public JwtUserDetails assertLoggedInUserAccount() {
        JwtUserDetails loggedInUserAccount = getLoggedInUserAccount();
        if (loggedInUserAccount == null) {
            throw new IllegalStateException("No UserAccount found in SecurityContext.");
        }
        return loggedInUserAccount;
    }

    @Nullable
    private JwtUserDetails getLoggedInUserAccount() {
        var securityContext =
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (securityContext instanceof JwtUserDetails) {
            return (JwtUserDetails) securityContext;
        }

        log.warn("No UserAccount found in SecurityContext.");
        return null;
    }
}
