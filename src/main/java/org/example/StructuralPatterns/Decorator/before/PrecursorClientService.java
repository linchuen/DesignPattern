package org.example.StructuralPatterns.Decorator.before;

import org.example.StructuralPatterns.Decorator.object.PlainTextMessage;
import org.example.StructuralPatterns.Decorator.object.ClientType;

public class PrecursorClientService {

    public void sendMessage(ClientType clientType) {
        if (clientType == ClientType.Apple) {
            System.out.println("發送訊息給" + ClientType.Apple.name());
            String message = new PlainTextMessage().getMessage();
            String headerMessage = addHeader(message);
            String footerMessage = addFooter(headerMessage);
            String encryptMessage = encrypt(footerMessage);
            System.out.println(encryptMessage);
        } else if (clientType == ClientType.Google) {
            System.out.println("發送訊息給" + ClientType.Google.name());
            String message = new PlainTextMessage().getMessage();
            String footerMessage = addFooter(message);
            String encryptMessage = encrypt(footerMessage);
            System.out.println(encryptMessage);
        }
    }

    private String addHeader(String message) {
        return "加上頭部部文字 " + message;
    }

    private String addFooter(String message) {
        return message + " 加上尾部文字";
    }

    private String encrypt(String message) {
        return "這是加密後的文本\n" + message + "\n加密結束";
    }
}
