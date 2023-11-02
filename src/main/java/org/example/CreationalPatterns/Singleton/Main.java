package org.example.CreationalPatterns.Singleton;

import org.example.CreationalPatterns.Singleton.after.Singleton;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture.runAsync(Singleton::getInstance);
        CompletableFuture.runAsync(Singleton::getInstance);
    }
}