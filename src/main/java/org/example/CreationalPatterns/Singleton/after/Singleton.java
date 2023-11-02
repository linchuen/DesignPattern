package org.example.CreationalPatterns.Singleton.after;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("建立instance");
    }

    public static Singleton getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance != null) {
                return instance;
            }
            instance = new Singleton();
            return instance;
        }
    }
}
