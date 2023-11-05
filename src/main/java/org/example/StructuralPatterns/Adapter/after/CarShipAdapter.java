package org.example.StructuralPatterns.Adapter.after;

import org.example.StructuralPatterns.Adapter.object.Car;
import org.example.StructuralPatterns.Adapter.object.Ship;

public class CarShipAdapter implements Car, Ship {
    private final Car car;

    public CarShipAdapter(Car car) {
        this.car = car;
    }


    @Override
    public void drive() {
        car.drive();
    }

    @Override
    public void sail() {
        car.drive();
        System.out.println("轉換成船槳");
        System.out.println("車型輪船運作中");
    }
}
