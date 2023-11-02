package org.example.BehavioralPatterns.Strategy;

import org.example.BehavioralPatterns.Strategy.object.List;
import org.example.BehavioralPatterns.Strategy.object.SortType;
import org.example.BehavioralPatterns.Strategy.after.StrategyList;
import org.example.BehavioralPatterns.Strategy.before.PrecursorList;

public class Main {

    public static void main(String[] args) {
        System.out.println("precursorList");
        List precursorList = new PrecursorList();
        precursorList.sort(SortType.BubbleSort);
        precursorList.sort(SortType.QuickSort);
        precursorList.sort(SortType.MergeSort);
        System.out.println();

        System.out.println("strategyList");
        List strategyList = new StrategyList();
        strategyList.sort(SortType.BubbleSort);
        strategyList.sort(SortType.QuickSort);
        strategyList.sort(SortType.MergeSort);
        System.out.println();
    }
}