package org.example.StructuralPatterns.Proxy;

import org.example.StructuralPatterns.Proxy.after.DisneyVideoSupplier;
import org.example.StructuralPatterns.Proxy.after.DisneyVideoSupplierProxy;
import org.example.StructuralPatterns.Proxy.object.Video;
import org.example.StructuralPatterns.Proxy.object.VideoSupplier;

public class Main {
    public static void main(String[] args) {
        DisneyVideoSupplier disneyVideoSupplier = new DisneyVideoSupplier();
        VideoSupplier disneyVideoSupplierProxy = new DisneyVideoSupplierProxy(disneyVideoSupplier);

        Video v1 = disneyVideoSupplier.downloadVideo("冰雪奇緣");
        Video v2 = disneyVideoSupplier.downloadVideo("冰雪奇緣");
        Video v3 = disneyVideoSupplier.downloadVideo("冰雪奇緣");
        assert v1 != v2 && v2 != v3;
        System.out.println();

        Video p1 = disneyVideoSupplierProxy.downloadVideo("冰雪奇緣");
        Video p2 = disneyVideoSupplierProxy.downloadVideo("冰雪奇緣");
        Video p3 = disneyVideoSupplierProxy.downloadVideo("冰雪奇緣");
        assert p1 == p2 && p2 == p3;
    }
}