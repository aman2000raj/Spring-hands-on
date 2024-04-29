package org.aman.exceptions;

public class UserServiceException extends RuntimeException {
    /**
     * param message
     */
    private static final long serialVersionUID = 1L;
    public UserServiceException(String message) {
        super(message);
    }
}
