package org.example.StructuralPatterns.Facade.object;

public class VideoFile {
    private String name;
    private String codecType;

    public VideoFile(String name, String codecType) {
        this.name = name;
        this.codecType = codecType;
    }

    public void setCodecType(String codecType) {
        this.codecType = codecType;
    }

    public String getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }
}
