package org.example.BehavioralPatterns.Mediator.usual;

import java.util.ArrayList;
import java.util.List;

public class Switch implements Mediator {
    private final List<Colleague> colleagueList = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        colleagueList.add(colleague);
    }

    @Override
    public void request(String ipAddress) {
        for (Colleague colleague : colleagueList) {
            if (colleague.receive(ipAddress)) {
                String message = colleague.reply();
                reply(message);
                return;
            }
        }
        reply("");
    }

    @Override
    public void reply(String message) {
        if (!message.isBlank()) {
            System.out.println("有搜尋到該" + message + "位置");
        } else {
            System.out.println("搜尋不到該ip位置");
        }
    }
}
