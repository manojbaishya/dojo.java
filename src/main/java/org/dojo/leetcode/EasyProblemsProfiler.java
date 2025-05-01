package org.dojo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * EasyProblemsProfiler Demo
 */
public class EasyProblemsProfiler {
    public static void run() {
        var profiler = new EasyProblemsProfiler();
        var _ = profiler.romanToInt();
        var _ = profiler.longestCommonPrefix();
    }

    private final EasyProblems sut = new EasyProblems();
    private final int ITERATIONS = 100000;

    public List<Integer> romanToInt() {
        String[] romanNumerals = new String[] {"III", "LVIII", "MCMXCIV", "MMMCMXCIX", "MMMCXCIX", "XLIX", "CMXCIX"};

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < ITERATIONS; j++) {
            System.out.printf("[INFO] Executing EasyProblemsBenchmark.romanToInt(): Iteration %d\n", j);
            for (String romanNumeral : romanNumerals) {
                int actual = sut.romanToInt(romanNumeral);
                result.add(actual);
            }
        }
        return result;
    }

    public List<String> longestCommonPrefix() {
        String[] strs = new String[] {"flower", "flow", "flight"};

        List<String> result = new ArrayList<>();
        for (int j = 0; j < ITERATIONS; j++) {
            System.out.printf("[INFO] Executing EasyProblemsBenchmark.longestCommonPrefix(): Iteration %d\n", j);
            String actual = sut.longestCommonPrefix(strs);
            result.add(actual);
        }

        return result;
    }
}
