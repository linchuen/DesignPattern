package org.example.BehavioralPatterns.Visitor.object;

public class MemberData {
    private final String name;
    private final MemberType type;

    public MemberData(String name, MemberType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public MemberType getType() {
        return type;
    }
}
