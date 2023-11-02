
package org.example.CreationalPatterns.Prototype.after;

public class ShallowClone implements Cloneable {
    private String attribute;
    private ObjectAttribute objectAttribute;

    public ShallowClone(String attribute, ObjectAttribute objectAttribute) {
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
    public ShallowClone clone() throws CloneNotSupportedException {
        return (ShallowClone)super.clone();
    }

    public static class ObjectAttribute {
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
    }
}
