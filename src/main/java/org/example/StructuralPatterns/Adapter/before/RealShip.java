package org.example.StructuralPatterns.Adapter.before;

import org.example.StructuralPatterns.Adapter.object.Ship;

public class RealShip implements Ship {

    @Override
    public void sail() {
        System.out.println("輪船運作中");
    }
}
