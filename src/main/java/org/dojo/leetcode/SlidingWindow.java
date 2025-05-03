package org.dojo.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SlidingWindow {
    // TODO: Implement int SlidingWindow.maxFrequency(int[], int)
    // Leetcode problem 1838. Frequency of the Most Frequent Element
    public int maxFrequency(int[] nums, int k) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Uses Set of fixed size to detect duplicates
     * while scanning over the array only once.
     *
     * @param nums array to check for duplicates
     * @param k    maximum allowed distance between duplicates
     * @return true if duplicates exist within distance k
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>(k + 1);

        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) return true;
            window.add(nums[i]);
            if (window.size() > k) window.remove(nums[i - k]);
        }

        return false;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;

        Map<Character, Integer> cmpFreq = getCharCounts(t);
        Map<Character, Integer> testFreq = new HashMap<>(uniqueCharCount(s));
        PriorityQueue<int[]> minLengthsToWindows = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1] - a[0])
        );

        int start = 0;
        int missing = cmpFreq.size();
        for (int end = 0; end < s.length(); end++) {
            char inserted = s.charAt(end);
            testFreq.merge(inserted, 1, Integer::sum);

            if (cmpFreq.containsKey(inserted) &&
                    testFreq.get(inserted).equals(cmpFreq.get(inserted))) {
                missing--;
            }

            if (end + 1 - start < t.length()) continue;
            if (missing > 0) continue;

            while (missing == 0) {
                char yanked = s.charAt(start);

                if (testFreq.get(yanked) > 1) {
                    testFreq.merge(yanked, -1, Integer::sum);
                } else {
                    testFreq.remove(yanked);
                }

                if (cmpFreq.containsKey(yanked) &&
                        (!testFreq.containsKey(yanked) ||
                                testFreq.get(yanked) < cmpFreq.get(yanked))) {
                    missing++;
                }

                start++;
            }

            minLengthsToWindows.offer(new int[] {start - 1, end + 1});
        }

        if (minLengthsToWindows.isEmpty()) return "";

        int[] idxs = minLengthsToWindows.poll();
        return s.substring(idxs[0], idxs[1]);
    }

    public static Map<Character, Integer> getCharCounts(String input) {
        int count = uniqueCharCount(input);
        Map<Character, Integer> charCounts = new HashMap<>(count);

        for (char c : input.toCharArray()) {
            charCounts.merge(c, 1, Integer::sum);
        }

        return charCounts;
    }

    public static int uniqueCharCount(String input) {
        boolean[] seen = new boolean[52];
        int uniqueCount = 0;

        for (char c : input.toCharArray()) {
            int index = (c >= 'a') ? (c - 'a' + 26) : (c - 'A');
            if (!seen[index]) {
                seen[index] = true;
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
}
