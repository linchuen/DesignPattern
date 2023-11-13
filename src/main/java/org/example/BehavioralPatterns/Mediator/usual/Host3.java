package org.example.BehavioralPatterns.Mediator.usual;

public class Host3 implements Colleague{
    private final Mediator mediator;

    public Host3(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public boolean receive(String ipAddress) {
        return getIpAddress().equals(ipAddress);
    }

    @Override
    public String reply() {
        return getIpAddress();
    }

    @Override
    public void send(String ipAddress) {
        mediator.request(ipAddress);
    }

    @Override
    public String getIpAddress() {
        return "192.168.0.3";
    }
}
