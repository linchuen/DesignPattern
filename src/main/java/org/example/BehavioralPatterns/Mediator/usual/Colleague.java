package org.example.BehavioralPatterns.Mediator.usual;

public interface Colleague {
    boolean receive(String ipAddress);

    String reply();

    void send(String ipAddress);

    String getIpAddress();
}
