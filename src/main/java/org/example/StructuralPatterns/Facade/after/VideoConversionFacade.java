package org.example.StructuralPatterns.Facade.after;

import org.example.StructuralPatterns.Facade.object.Codec;
import org.example.StructuralPatterns.Facade.object.Mp4Codec;
import org.example.StructuralPatterns.Facade.object.OggCodec;
import org.example.StructuralPatterns.Facade.object.VideoFile;

public class VideoConversionFacade {

    public VideoFile convertVideo(String fullFileName, String format) throws NoSuchMethodException {
        String[] fullFileNameParts = fullFileName.split("\\.");

        VideoFile file = new VideoFile(fullFileNameParts[0], fullFileNameParts[1]);
        System.out.println("轉檔前格式:" + fullFileNameParts[1]);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new Mp4Codec();
        } else if (format.equals("ogg")) {
            destinationCodec = new OggCodec();
        } else {
            throw new NoSuchMethodException();
        }
        return destinationCodec.doALotOfThings(file);
    }
}
