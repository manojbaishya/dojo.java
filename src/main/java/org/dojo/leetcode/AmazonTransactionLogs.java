package org.dojo.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AmazonTransactionLogs
{
    public List<String> processLogs(List<String> logs, int threshold)
    {
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

        for(String txn : logs)
        {
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
}
