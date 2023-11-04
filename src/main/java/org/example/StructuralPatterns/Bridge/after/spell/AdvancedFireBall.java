package org.example.StructuralPatterns.Bridge.after.spell;

import org.example.StructuralPatterns.Bridge.after.object.Spell;
import org.example.StructuralPatterns.Bridge.object.SpellType;

public class AdvancedFireBall implements Spell {
    @Override
    public String get() {
        return SpellType.AdvancedFireBall.getName();
    }
}
