package org.example.StructuralPatterns.Proxy.after;

import org.example.StructuralPatterns.Proxy.object.Video;
import org.example.StructuralPatterns.Proxy.object.VideoSupplier;

public class DisneyVideoSupplier implements VideoSupplier {
    @Override
    public Video downloadVideo(String name) {
        System.out.println("從迪士尼下載影片:" + name);
        return new Video(name);
    }
}
