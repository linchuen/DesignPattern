package org.example.StructuralPatterns.Decorator.after;

import org.example.StructuralPatterns.Decorator.object.ClientType;
import org.example.StructuralPatterns.Decorator.object.PlainTextMessage;

public class ClientService {

    public void sendMessage(ClientType clientType) {
        if (clientType == ClientType.Apple) {
            System.out.println("發送訊息給" + ClientType.Apple.name());
            String message = new EncryptMessageDecorator(new FooterMessageDecorator(new HeaderMessageDecorator(new PlainTextMessage()))).getMessage();
            System.out.println(message);
        } else if (clientType == ClientType.Google) {
            System.out.println("發送訊息給" + ClientType.Google.name());
            String message = new EncryptMessageDecorator(new FooterMessageDecorator(new PlainTextMessage())).getMessage();
            System.out.println(message);
        }
    }
}
