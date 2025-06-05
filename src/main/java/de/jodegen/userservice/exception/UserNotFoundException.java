package de.jodegen.userservice.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long userId) {
        super("User with ID " + userId + " not found.");
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
