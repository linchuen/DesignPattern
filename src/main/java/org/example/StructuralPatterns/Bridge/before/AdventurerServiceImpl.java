package org.example.StructuralPatterns.Bridge.before;

import org.example.StructuralPatterns.Bridge.before.object.AdventurerService;
import org.example.StructuralPatterns.Bridge.before.object.AdventurerType;
import org.example.StructuralPatterns.Bridge.object.SpellType;
import org.example.StructuralPatterns.Bridge.object.WeaponType;

public class AdventurerServiceImpl implements AdventurerService {
    @Override
    public void attack(AdventurerType adventurerType) {
        if (adventurerType == AdventurerType.Warrior) {
            attackWithWeapon(WeaponType.Sword);
        } else if (adventurerType == AdventurerType.TraineeMagician) {
            attackWithWeapon(WeaponType.Staff);
        } else if (adventurerType == AdventurerType.SuperMagician) {
            attackWithWeapon(WeaponType.Staff);
        }
    }

    @Override
    public void castSpell(AdventurerType adventurerType) {
        if (adventurerType == AdventurerType.Warrior) {
            castWithSpell(SpellType.FireBall);
        } else if (adventurerType == AdventurerType.TraineeMagician) {
            castWithSpell(SpellType.FireBall);
        } else if (adventurerType == AdventurerType.SuperMagician) {
            castWithSpell(SpellType.AdvancedFireBall);
        }
    }

    private void attackWithWeapon(WeaponType weaponType) {
        System.out.println("使用" + weaponType.getName() + "攻擊");
    }

    private void castWithSpell(SpellType spellType) {
        System.out.println("施放" + spellType.getName() + "法術");
    }
}
