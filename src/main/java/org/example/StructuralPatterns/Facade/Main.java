package org.example.StructuralPatterns.Facade;

import org.example.StructuralPatterns.Facade.after.VideoConversionFacade;
import org.example.StructuralPatterns.Facade.object.VideoFile;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        VideoConversionFacade videoConversionFacade = new VideoConversionFacade();
        VideoFile result = videoConversionFacade.convertVideo("123.mp4", "ogg");
        System.out.println("轉檔後格式:" + result.getCodecType());
    }
}