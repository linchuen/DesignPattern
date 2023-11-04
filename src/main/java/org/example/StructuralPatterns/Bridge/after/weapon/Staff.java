package org.example.StructuralPatterns.Bridge.after.weapon;

import org.example.StructuralPatterns.Bridge.after.object.Weapon;
import org.example.StructuralPatterns.Bridge.object.WeaponType;

public class Staff implements Weapon {
    @Override
    public String get() {
        return WeaponType.Staff.getName();
    }
}
