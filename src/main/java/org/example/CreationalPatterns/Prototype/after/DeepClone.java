package org.example.CreationalPatterns.Prototype.after;

public class DeepClone implements Cloneable {
    private String attribute;
    private ObjectAttribute objectAttribute;

    public DeepClone(String attribute, ObjectAttribute objectAttribute) {
        this.attribute = attribute;
        this.objectAttribute = objectAttribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public ObjectAttribute getObjectAttribute() {
        return objectAttribute;
    }

    public void setObjectAttribute(ObjectAttribute objectAttribute) {
        this.objectAttribute = objectAttribute;
    }

    @Override
    public DeepClone clone() throws CloneNotSupportedException {
        DeepClone deepClone = (DeepClone) super.clone();
        deepClone.objectAttribute = (ObjectAttribute) this.objectAttribute.clone();
        return deepClone;
    }

    public static class ObjectAttribute implements Cloneable{
        private String attribute;

        public ObjectAttribute(String attribute) {
            this.attribute = attribute;
        }

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
