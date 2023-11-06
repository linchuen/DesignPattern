package org.example.StructuralPatterns.Flyweight.object;

public class GpsMachine {
    private long id;
    private int locationX;
    private int locationY;
    private BasicInfo basicInfo;

    public void setId(long id) {
        this.id = id;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public static class BasicInfo{
        private final int seriesId;
        private final String  seriesName;
        private final String description;

        public BasicInfo(int seriesId, String seriesName, String description) {
            this.seriesId = seriesId;
            this.seriesName = seriesName;
            this.description = description;
        }
    }
}
