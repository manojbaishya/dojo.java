package org.dojo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicMaths {
    public int evenlyDivides(int n) {
        int num = n;
        int count = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            if (lastDigit != 0 && n % lastDigit == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    public int reverseInteger(int x) {
        int reverseNumber = 0;
        int num = x;
        int lastDigit;

        while (num != 0) {
            lastDigit = num % 10;
            try {
                // Check for overflow before performing the operation
                if (reverseNumber > Integer.MAX_VALUE / 10 ||
                        (reverseNumber == Integer.MAX_VALUE / 10 && lastDigit > Integer.MAX_VALUE % 10) ||
                        reverseNumber < Integer.MIN_VALUE / 10 ||
                        (reverseNumber == Integer.MIN_VALUE / 10 && lastDigit < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
                reverseNumber = reverseNumber * 10 + lastDigit;
            } catch (ArithmeticException e) {
                return 0;
            }
            num /= 10;
        }

        return reverseNumber;
    }

    public boolean isPalindrome(int x) {
        return x >= 0 && reverseInteger(x) == x;
    }

    public boolean isArmstrongNumber(int num) {
        int copy = num;
        int sum = 0;
        while (copy != 0) {
            int lastDigit = copy % 10;
            sum += lastDigit * lastDigit * lastDigit;
            copy /= 10;
        }

        return sum == num;
    }

    public List<Integer> getAllDivisorsDesc(int N) {
        List<Integer> divisors = new ArrayList<>();
        double upperBound = Math.sqrt(N);
        for (int i = 1; i <= upperBound; i++) {
            if (N % i == 0) {
                divisors.add(i);
                int complement = N / i;
                if (complement != i) divisors.add(complement);
            }
        }

        divisors.sort(Collections.reverseOrder());
        return divisors;
    }

    public boolean isPrime(int N) {
        List<Integer> factors = getAllDivisorsDesc(N);
        return factors.size() == 2 && factors.contains(1) && factors.contains(N);
    }

    public int highestCommonFactor(int M, int N) {
        List<Integer> factorsM = getAllDivisorsDesc(M);
        List<Integer> factorsN = getAllDivisorsDesc(N);

        return factorsM.stream()
                       .filter(factorsN::contains)
                       .max(Integer::compareTo)
                       .orElse(1);
    }

    public int highestCommonFactorEuclidean(int M, int N) {
        while (M > 0 && N > 0) {
            if (M > N) M %= N;
            else N %= M;
        }

        return M == 0 ? N : M;
    }

    public int leastCommonMultiple(int M, int N) {
        int HCF = highestCommonFactorEuclidean(M, N);
        return (M * N) / HCF;
    }
}
