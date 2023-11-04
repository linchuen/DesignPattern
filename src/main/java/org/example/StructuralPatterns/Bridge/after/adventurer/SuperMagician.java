package org.example.StructuralPatterns.Bridge.after.adventurer;

import org.example.StructuralPatterns.Bridge.after.object.Adventurer;
import org.example.StructuralPatterns.Bridge.after.object.Spell;
import org.example.StructuralPatterns.Bridge.after.object.Weapon;

public class SuperMagician  implements Adventurer {
    private final Weapon weapon;
    private final Spell spell;

    public SuperMagician(Weapon weapon, Spell spell) {
        this.weapon = weapon;
        this.spell = spell;
    }

    @Override
    public void attack() {
        System.out.println("使用" + weapon.get() + "攻擊");
    }

    @Override
    public void castSpell() {
        System.out.println("施放" + spell.get() + "法術");
    }
}
