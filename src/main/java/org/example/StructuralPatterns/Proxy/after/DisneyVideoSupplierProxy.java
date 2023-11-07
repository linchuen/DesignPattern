package org.example.StructuralPatterns.Proxy.after;

import org.example.StructuralPatterns.Proxy.object.Video;
import org.example.StructuralPatterns.Proxy.object.VideoSupplier;

import java.util.HashMap;
import java.util.Map;

public class DisneyVideoSupplierProxy implements VideoSupplier {
    private final DisneyVideoSupplier disneyVideoSupplier;
    private final Map<String, Video> videoLocalMap = new HashMap<>();

    public DisneyVideoSupplierProxy(DisneyVideoSupplier disneyVideoSupplier) {
        this.disneyVideoSupplier = disneyVideoSupplier;
    }

    @Override
    public Video downloadVideo(String name) {
        Video localVideo = videoLocalMap.get(name);
        if (localVideo != null) {
            System.out.println("從本地取得影片資料");
            return localVideo;
        }
        Video video = disneyVideoSupplier.downloadVideo(name);
        videoLocalMap.put(name, video);
        return video;
    }
}
