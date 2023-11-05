package org.example.StructuralPatterns.Facade.object;

public class OggCodec implements Codec {
    @Override
    public VideoFile doALotOfThings(VideoFile file) {
        System.out.println("轉檔中");
        return  new VideoFile(file.getName(),"ogg");
    }
}
