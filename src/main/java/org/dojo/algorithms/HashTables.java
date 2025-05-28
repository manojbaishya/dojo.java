package org.dojo.algorithms;

import java.util.HashMap;
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
}
