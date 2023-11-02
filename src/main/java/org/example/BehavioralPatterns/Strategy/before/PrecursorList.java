package org.example.BehavioralPatterns.Strategy.before;

import org.example.BehavioralPatterns.Strategy.object.List;
import org.example.BehavioralPatterns.Strategy.object.SortType;

public class PrecursorList implements List {
    @Override
    public void sort(SortType sortType) {
        if (sortType == SortType.BubbleSort) {
            System.out.println("呼叫BubbleSort進行排序");
        } else if (sortType == SortType.QuickSort) {
            System.out.println("呼叫QuickSort進行排序");
        } else if (sortType == SortType.MergeSort) {
            System.out.println("呼叫MergeSort進行排序");
        }
    }
}
