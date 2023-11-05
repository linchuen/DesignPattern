package org.example.StructuralPatterns.Adapter;

import org.example.StructuralPatterns.Adapter.after.CarShipAdapter;
import org.example.StructuralPatterns.Adapter.after.RealCar;
import org.example.StructuralPatterns.Adapter.before.PrecursorRealCar;
import org.example.StructuralPatterns.Adapter.object.Car;
import org.example.StructuralPatterns.Adapter.object.Ship;

public class Main {
    public static void main(String[] args) {
        System.out.println("precursorLetterBuilder");
        PrecursorRealCar precursorRealCar = new PrecursorRealCar();
        precursorRealCar.drive();
        Ship realShip = precursorRealCar.convert();
        realShip.sail();
        System.out.println();

        System.out.println("factoryLetterBuilder");
        Car realCar = new RealCar();
        realCar.drive();
        CarShipAdapter carShipAdapter = new CarShipAdapter(realCar);
        carShipAdapter.sail();
        System.out.println();
    }
}
