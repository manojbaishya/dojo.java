package org.dojo.algorithms;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HashTables {
    public int[] countFrequencies(int[] arr) {
        TreeMap<Integer, Integer> frequencies = new TreeMap<>();
        for (int j : arr) frequencies.merge(j, 1, Integer::sum);
        int[] freqArray = new int[arr.length];
        for (int key : frequencies.keySet()) freqArray[key - 1] = frequencies.get(key);
        return freqArray;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[] {map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public int[] twoSumAlt(int[] nums, int target) {
        Map<Integer, Integer> lookbehind = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (lookbehind.containsKey(target - nums[i])) return new int[] {lookbehind.get(target - nums[i]), i};
            lookbehind.put(nums[i], i);
        }
        return new int[] {};
    }

    public List<Pair<Integer, Integer>> twoSumAlt2(int[] nums, int target) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        Map<Integer, Integer> lookbehind = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (lookbehind.containsKey(target - nums[i])) pairs.add(Pair.of(lookbehind.get(target - nums[i]), i));
            lookbehind.put(nums[i], i);
        }
        return pairs;
    }
}
