package org.dojo.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OnlineAssessmentQuestions {
    public List<String> processLogs(List<String> logs, int threshold) {
        Map<String, Integer> transactions = getTransactionFrequencies(logs);

        Map<String, Integer> excessiveUsers = transactions
                .entrySet().stream()
                .filter(pair -> pair.getValue() >= threshold)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return excessiveUsers
                .keySet().stream()
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    private static Map<String, Integer> getTransactionFrequencies(List<String> logs) {
        Map<String, Integer> transactions = new HashMap<>();

        for (String txn : logs) {
            String[] data = txn.split(" ");

            String sender = data[0];
            String receiver = data[1];

            if (sender.equals(receiver)) {
                if (transactions.containsKey(sender)) transactions.put(sender, transactions.get(sender) + 1);
                else transactions.put(sender, 1);
            } else {
                if (transactions.containsKey(sender)) transactions.put(sender, transactions.get(sender) + 1);
                else transactions.put(sender, 1);

                if (transactions.containsKey(receiver)) transactions.put(receiver, transactions.get(receiver) + 1);
                else transactions.put(receiver, 1);
            }
        }
        return transactions;
    }

    public int[] getItemsInClosedContainers(String compartments, int[] startIndices, int[] endIndices) {
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < startIndices.length; i++) {
            int startIndex = startIndices[i] - 1;
            int endIndex = endIndices[i];

            int countOfItems = 0;
            List<Integer> walls = new ArrayList<>();

            for (int k = startIndex; k < endIndex; k++) {
                if (compartments.charAt(k) == '|') walls.add(k);
            }

            if (walls.size() < 2) continue;
            for (int j = 1; j < walls.size(); j++) countOfItems += walls.get(j) - (walls.get(j - 1) + 1);
            counts.add(countOfItems);
        }

        return counts.stream().mapToInt(Integer::intValue).toArray();
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        Set<Character> uniqueCharset = new HashSet<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            while (uniqueCharset.contains(c)) {
                uniqueCharset.remove(s.charAt(start));
                start++;
            }
            boolean added = uniqueCharset.add(c);
            if (added) maxLength = Math.max(maxLength, end + 1 - start);
        }

        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }

    public int[] minimalHeaviestBox(int[] weights) {
        // Sort weights in descending order - O(nlgn)
        Integer[] boxWeights = Arrays.stream(weights)
                                     .boxed()
                                     .sorted(Comparator.reverseOrder())
                                     .toArray(Integer[]::new);

        // Dynamic Programming approach
        int totalSum = Arrays.stream(weights).sum();
        int minSizeSum = boxWeights[0];
        int complementSum = totalSum - boxWeights[0];

        int minLength = weights.length;
        if (minSizeSum > complementSum) {
            minLength = 1;
        } else {
            for (int k = 1; k < weights.length; k++) {
                minSizeSum += boxWeights[k];
                complementSum = totalSum - minSizeSum;

                if (minSizeSum > complementSum) {
                    minLength = k + 1;
                    break;
                }
            }
        }

        int[] results = new int[minLength];
        for (int j = minLength - 1, m = 0; j >= 0; j--, m++) {
            results[m] = boxWeights[j];
        }
        return results;
    }
}
