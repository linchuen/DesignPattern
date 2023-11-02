package org.example.CreationalPatterns.Builder.object;

public class Exodia {

    private ExodiaTheForbiddenOne head;
    private LeftArmOfTheForbiddenOne leftArm;
    private RightArmOfTheForbiddenOne rightArm;
    private LeftLegOfTheForbiddenOne leftLeg;
    private RightLegOfTheForbiddenOne rightLeg;

    public Exodia() {
        System.out.println("召喚沒有組件的黑暗大法師");
    }

    public Exodia(ExodiaTheForbiddenOne head, LeftArmOfTheForbiddenOne leftArm, RightArmOfTheForbiddenOne rightArm, LeftLegOfTheForbiddenOne leftLeg, RightLegOfTheForbiddenOne rightLeg) {
        this.head = head;
        this.leftArm = leftArm;
        this.rightArm = rightArm;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
        System.out.println("召喚完整的黑暗大法師");
    }

    public void setHead(ExodiaTheForbiddenOne head) {
        System.out.println("組裝頭部");
        this.head = head;
    }

    public void setLeftArm(LeftArmOfTheForbiddenOne leftArm) {
        System.out.println("組裝左腕");
        this.leftArm = leftArm;
    }

    public void setRightArm(RightArmOfTheForbiddenOne rightArm) {
        System.out.println("組裝右腕");
        this.rightArm = rightArm;
    }

    public void setLeftLeg(LeftLegOfTheForbiddenOne leftLeg) {
        System.out.println("組裝左腳");
        this.leftLeg = leftLeg;
    }

    public void setRightLeg(RightLegOfTheForbiddenOne rightLeg) {
        System.out.println("組裝右腳");
        this.rightLeg = rightLeg;
    }

    public ExodiaTheForbiddenOne getHead() {
        return head;
    }

    public LeftArmOfTheForbiddenOne getLeftArm() {
        return leftArm;
    }

    public RightArmOfTheForbiddenOne getRightArm() {
        return rightArm;
    }

    public LeftLegOfTheForbiddenOne getLeftLeg() {
        return leftLeg;
    }

    public RightLegOfTheForbiddenOne getRightLeg() {
        return rightLeg;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ExodiaTheForbiddenOne head;
        private LeftArmOfTheForbiddenOne leftArm;
        private RightArmOfTheForbiddenOne rightArm;
        private LeftLegOfTheForbiddenOne leftLeg;
        private RightLegOfTheForbiddenOne rightLeg;

        public Builder head(ExodiaTheForbiddenOne head) {
            System.out.println("組裝頭部");
            this.head = head;
            return this;
        }

        public Builder leftArm(LeftArmOfTheForbiddenOne leftArm) {
            System.out.println("組裝左腕");
            this.leftArm = leftArm;
            return this;
        }

        public Builder rightArm(RightArmOfTheForbiddenOne rightArm) {
            System.out.println("組裝右腕");
            this.rightArm = rightArm;
            return this;
        }

        public Builder leftLeg(LeftLegOfTheForbiddenOne leftLeg) {
            System.out.println("組裝左腳");
            this.leftLeg = leftLeg;
            return this;
        }

        public Builder rightLeg(RightLegOfTheForbiddenOne rightLeg) {
            System.out.println("組裝右腳");
            this.rightLeg = rightLeg;
            return this;
        }

        public Exodia build() {
            assert head != null;
            assert leftArm != null;
            assert rightArm != null;
            assert leftLeg != null;
            assert rightLeg != null;
            return new Exodia(head, leftArm, rightArm, leftLeg, rightLeg);
        }
    }
}
