package org.example.BehavioralPatterns.Strategy.after;

import org.example.BehavioralPatterns.Strategy.object.SortStrategy;

public class BubbleSort implements SortStrategy {
    @Override
    public void sort() {
        System.out.println("呼叫BubbleSort進行排序");
    }
}
