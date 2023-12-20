package org.example.StructuralPatterns.Adapter.before;

import org.example.StructuralPatterns.Adapter.object.Car;
import org.example.StructuralPatterns.Adapter.object.Ship;

public class RealCar implements Car {
    @Override
    public void drive() {
        System.out.println("車子運作中");
    }
}
