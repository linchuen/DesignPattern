package org.example.StructuralPatterns.Adapter.before;

import org.example.StructuralPatterns.Adapter.object.Car;
import org.example.StructuralPatterns.Adapter.object.Ship;

public class PrecursorRealCar implements Car {
    @Override
    public void drive() {
        System.out.println("車子運作中");
    }

    public Ship convert(){
        System.out.println("轉換成船槳");
        return new RealShip();
    }
}
