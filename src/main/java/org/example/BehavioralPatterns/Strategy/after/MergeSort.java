package org.example.BehavioralPatterns.Strategy.after;

import org.example.BehavioralPatterns.Strategy.object.SortStrategy;

public class MergeSort implements SortStrategy {
    @Override
    public void sort() {
        System.out.println("呼叫MergeSort進行排序");
    }
}
