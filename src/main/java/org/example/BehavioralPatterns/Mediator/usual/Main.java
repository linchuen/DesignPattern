package org.example.BehavioralPatterns.Mediator.usual;

public class Main {
    public static void main(String[] args) {
        Switch sw = new Switch();
        Host1 host1 = new Host1(sw);
        Host2 host2 = new Host2(sw);
        Host3 host3 = new Host3(sw);
        sw.register(host1);
        sw.register(host2);
        sw.register(host3);

        host1.send("192.168.0.2");
        host1.send("192.168.0.4");

        host2.send("192.168.0.3");
    }
}
