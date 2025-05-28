package org.dojo.algorithms;

import java.util.HashSet;
import java.util.List;

public class RuntimeAnalysis {
    public static <T> boolean hasDuplicates(List<T> list) {
        int size = list.size();
        for (var i = 0; i < size; i++) {
            for (var j = 0; j < i; j++) {
                if (list.get(i).equals(list.get(j))) return true;
            }
        }
        return false;
    }

    public static <T> boolean hasDuplicatesWithSorting(List<T> list) {
        List<T> sortedList = list.stream().sorted().toList();
        for (var i = 0; i < sortedList.size() - 1; i++)
        {
            if (sortedList.get(i).equals(sortedList.get(i + 1))) return true;
        }
        return false;
    }

    public static <T> boolean hasDuplicatesWithSets(List<T> list) {
        var set = new HashSet<T>();
        return list.stream().anyMatch(item -> !set.add(item));
    }

    public static <T> boolean hasDuplicatesWithSetLength(List<T> list) {
        var set = new HashSet<>(list);
        return set.size() != list.size();
    }
}
