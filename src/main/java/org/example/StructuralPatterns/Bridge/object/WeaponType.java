package org.example.StructuralPatterns.Bridge.object;

public enum WeaponType {
    Sword("劍"),
    Staff("法杖");

    private final String name;

    WeaponType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
