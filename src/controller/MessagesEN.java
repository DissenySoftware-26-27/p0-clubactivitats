package controller;

import model.exceptions.*;

// TO DO moure a controller + crear classes per exceptions
public enum MessagesEN {
    // Exception messages

    InsufficientCreditException("The virtual card has not enough credit"),
    TopUpLimitReachedException("Top up limit reached");
    // Success messages

    private final String message;

    MessagesEN(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String translate(Exception e) {
        // Depending on the type of the Exception we will return the corresponding message
        if (e instanceof InsufficientCreditException) {
            return InsufficientCreditException.getMessage();
        } else if (e instanceof TopUpLimitReachedException) {
            return TopUpLimitReachedException.getMessage();
        } else {
            return "An error occurred";
        }
    }

}
