package org.example.StructuralPatterns.Adapter;

import org.example.StructuralPatterns.Adapter.after.CarShipAdapter;
import org.example.StructuralPatterns.Adapter.after.RefactorRealCar;
import org.example.StructuralPatterns.Adapter.after.RefactorRealShip;
import org.example.StructuralPatterns.Adapter.before.RealCar;
import org.example.StructuralPatterns.Adapter.before.RealShip;
import org.example.StructuralPatterns.Adapter.object.Car;
import org.example.StructuralPatterns.Adapter.object.Ship;

public class Main {
    public static void main(String[] args) {
        System.out.println("before");
        RealCar realCar = new RealCar();
        realCar.drive();
        RealShip realShip = new RealShip();
        realShip.sail();
        System.out.println();

        System.out.println("after");
        Car refactorRealCar = new RefactorRealCar();
        refactorRealCar.drive();
        CarShipAdapter carShipAdapter = new CarShipAdapter(refactorRealCar);
        Ship refactorRealShip = new RefactorRealShip(carShipAdapter);
        refactorRealShip.sail();
        System.out.println();
    }
}
