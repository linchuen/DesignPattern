package org.example.CreationalPatterns.Prototype;

import org.example.CreationalPatterns.Prototype.after.DeepClone;
import org.example.CreationalPatterns.Prototype.after.ShallowClone;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("ShallowClone");
        System.out.println("============================");
        System.out.println("Before update");
        ShallowClone shallowClone = new ShallowClone("shallowClone", new ShallowClone.ObjectAttribute("inner attribute"));
        ShallowClone copyShallowClone = shallowClone.clone();

        System.out.println("shallowClone attribute = " + shallowClone.getAttribute());
        System.out.println("shallowClone inner attribute = " + shallowClone.getObjectAttribute().getAttribute());
        System.out.println("copyShallowClone attribute = " + copyShallowClone.getAttribute());
        System.out.println("copyShallowClone inner attribute = " + copyShallowClone.getObjectAttribute().getAttribute());
        System.out.println();

        System.out.println("After update");
        copyShallowClone.setAttribute("new attribute");
        copyShallowClone.getObjectAttribute().setAttribute("new inner attribute");

        System.out.println("shallowClone attribute = " + shallowClone.getAttribute());
        System.out.println("shallowClone inner attribute = " + shallowClone.getObjectAttribute().getAttribute());
        System.out.println("copyShallowClone attribute = " + copyShallowClone.getAttribute());
        System.out.println("copyShallowClone inner attribute = " + copyShallowClone.getObjectAttribute().getAttribute());
        assert !shallowClone.getAttribute().equals(copyShallowClone.getAttribute());
        assert shallowClone.getObjectAttribute().getAttribute() == copyShallowClone.getObjectAttribute().getAttribute();
        System.out.println();

        System.out.println("DeepClone");
        System.out.println("============================");
        System.out.println("Before update");
        DeepClone deepClone = new DeepClone("deepClone", new DeepClone.ObjectAttribute("inner attribute"));
        DeepClone copyDeepClone = deepClone.clone();

        System.out.println("deepClone attribute = " + deepClone.getAttribute());
        System.out.println("deepClone inner attribute = " + deepClone.getObjectAttribute().getAttribute());
        System.out.println("copyDeepClone attribute = " + copyDeepClone.getAttribute());
        System.out.println("copyDeepClone inner attribute = " + copyDeepClone.getObjectAttribute().getAttribute());
        System.out.println();

        System.out.println("After update");
        copyDeepClone.setAttribute("new attribute");
        copyDeepClone.getObjectAttribute().setAttribute("new inner attribute");

        System.out.println("deepClone attribute = " + deepClone.getAttribute());
        System.out.println("deepClone inner attribute = " + deepClone.getObjectAttribute().getAttribute());
        System.out.println("copyDeepClone attribute = " + copyDeepClone.getAttribute());
        System.out.println("copyDeepClone inner attribute = " + copyDeepClone.getObjectAttribute().getAttribute());
        assert !deepClone.getAttribute().equals(copyDeepClone.getAttribute());
        assert deepClone.getObjectAttribute().getAttribute() != copyDeepClone.getObjectAttribute().getAttribute();
    }
}