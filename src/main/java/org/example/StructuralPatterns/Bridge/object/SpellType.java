package org.example.StructuralPatterns.Bridge.object;

public enum SpellType {
    FireBall("火球"),
    AdvancedFireBall("高級火球");
    private final String name;
    SpellType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
