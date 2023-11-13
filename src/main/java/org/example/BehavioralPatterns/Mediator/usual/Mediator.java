package org.example.BehavioralPatterns.Mediator.usual;

public interface Mediator {
    void register(Colleague colleague);
    void request(String ipAddress);
    void reply(String ipAddress);
}
