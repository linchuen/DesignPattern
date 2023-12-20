package org.example.StructuralPatterns.Adapter.after;

import org.example.StructuralPatterns.Adapter.object.Car;

public class RefactorRealCar implements Car {
    @Override
    public void drive() {
        System.out.println("車子運作中");
    }
}
