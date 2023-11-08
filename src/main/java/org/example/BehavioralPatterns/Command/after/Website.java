package org.example.BehavioralPatterns.Command.after;

import org.example.BehavioralPatterns.Command.object.Command;
import org.example.BehavioralPatterns.Command.object.CustomerData;
import org.example.BehavioralPatterns.Command.object.Invoker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Website implements Invoker {

    private final Map<CustomerData, Queue<Command>> customerCommandQueueMap = new HashMap<>();

    public void addCommand(CustomerData customerData, Command command) {
        Queue<Command> commandQueue = customerCommandQueueMap.getOrDefault(customerData, new LinkedList<>());
        commandQueue.add(command);
        customerCommandQueueMap.put(customerData, commandQueue);
    }

    public void removeAllCommand(CustomerData customerData) {
        customerCommandQueueMap.remove(customerData);
    }

    public void process(CustomerData customerData) {
        Queue<Command> commandQueue = customerCommandQueueMap.get(customerData);
        if (commandQueue.isEmpty()) return;

        for (Command command : commandQueue) {
            command.execute();
        }
    }
}
