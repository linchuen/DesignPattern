package org.example.StructuralPatterns.Adapter.after;

import org.example.StructuralPatterns.Adapter.object.Ship;

public class RefactorRealShip implements Ship {
    private final CarShipAdapter carShipAdapter;
    public RefactorRealShip(CarShipAdapter carShipAdapter) {
        this.carShipAdapter = carShipAdapter;
    }

    @Override
    public void sail() {
        carShipAdapter.sail();
    }
}
