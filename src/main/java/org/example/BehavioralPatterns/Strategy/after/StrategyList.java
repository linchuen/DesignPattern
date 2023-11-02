package org.example.BehavioralPatterns.Strategy.after;

import org.example.BehavioralPatterns.Strategy.object.List;
import org.example.BehavioralPatterns.Strategy.object.SortStrategy;
import org.example.BehavioralPatterns.Strategy.object.SortType;

import java.util.HashMap;
import java.util.Map;

public class StrategyList implements List {
    private final Map<SortType, SortStrategy> sortStrategyMap;

    public StrategyList() {
        sortStrategyMap = new HashMap<>();
        sortStrategyMap.put(SortType.BubbleSort, new BubbleSort());
        sortStrategyMap.put(SortType.QuickSort, new QuickSort());
        sortStrategyMap.put(SortType.MergeSort, new MergeSort());
    }

    @Override
    public void sort(SortType sortType) {
        SortStrategy sortStrategy = sortStrategyMap.get(sortType);
        sortStrategy.sort();
    }
}
