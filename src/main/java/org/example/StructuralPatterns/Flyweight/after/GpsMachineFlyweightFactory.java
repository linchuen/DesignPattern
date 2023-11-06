package org.example.StructuralPatterns.Flyweight.after;

import org.example.StructuralPatterns.Flyweight.object.GpsMachine;

import java.util.HashMap;
import java.util.Map;

public class GpsMachineFlyweightFactory {
    private final Map<Integer, GpsMachine.BasicInfo> seriesInfoMap = new HashMap<>();

    public GpsMachine build(long id, int x, int y, int seriesId) {
        GpsMachine gpsMachine = new GpsMachine();
        gpsMachine.setId(id);
        gpsMachine.setLocationX(x);
        gpsMachine.setLocationY(y);
        GpsMachine.BasicInfo basicInfo = seriesInfoMap.get(seriesId);
        if (basicInfo != null) {
            gpsMachine.setBasicInfo(basicInfo);
            return gpsMachine;
        } else {
            gpsMachine.setBasicInfo(new GpsMachine.BasicInfo(seriesId, "seriesName", "description"));
            return gpsMachine;
        }
    }
}
