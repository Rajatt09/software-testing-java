package com.software.testingjava.external;

public class ConsoleEmailClient implements EmailClient {
    @Override
    public void send(String emailAddress, String message) {
        System.out.println("Sending email to " + emailAddress + ": " + message);
    }
}
