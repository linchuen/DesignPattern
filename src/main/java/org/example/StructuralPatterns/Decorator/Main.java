package org.example.StructuralPatterns.Decorator;

import org.example.StructuralPatterns.Decorator.after.ClientService;
import org.example.StructuralPatterns.Decorator.before.PrecursorClientService;
import org.example.StructuralPatterns.Decorator.object.ClientType;

public class Main {

    public static void main(String[] args) {
        System.out.println("before");
        PrecursorClientService beforeClient = new PrecursorClientService();
        beforeClient.sendMessage(ClientType.Apple);
        System.out.println();
        beforeClient.sendMessage(ClientType.Google);
        System.out.println();

        System.out.println("after");
        ClientService afterClient = new ClientService();
        afterClient.sendMessage(ClientType.Apple);
        System.out.println();
        afterClient.sendMessage(ClientType.Google);
        System.out.println();
    }
}