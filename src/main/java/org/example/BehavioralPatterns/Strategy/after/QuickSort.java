package org.example.BehavioralPatterns.Strategy.after;

import org.example.BehavioralPatterns.Strategy.object.SortStrategy;

public class QuickSort implements SortStrategy {
    @Override
    public void sort() {
        System.out.println("呼叫QuickSort進行排序");
    }
}
