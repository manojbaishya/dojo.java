package org.dojo.algorithms;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // S = Smaller array
        // B = Bigger array
        int[] S = nums1.length <= nums2.length ? nums1 : nums2;
        int[] B = nums1.length <= nums2.length ? nums2 : nums1;

        // Let M be the merged array = [..S, ..B]
        // Size of a merged array is
        int MSize = S.length + B.length;

        // IMPORTANT: Median finding logic depends on whether M has even or odd count of elements
        boolean isEven = MSize % 2 == 0;

        // INVARIANT: The median of the merged array divides it into a one and only one correct symmetry:
        //      50% count on the left partition and 50% on the right partition;
        // if isEven, then M == LeftPartitionSize x 2 (due to integer division),
        //      else !isEven, then M == LeftPartitionSize x 2 - 1 (M + 1 is even)
        //      so for odd sized M, LeftPartitionSize = RightPartionSize + 1, this influences the formula for
        //      finding median for odd sized M
        int LEFTPARTITIONSIZE = (MSize + 1) >> 1; // CONSTANT

        // Binary search to find the correct element count from S (left partition of S)
        //      which goes into the left partition of M
        // Let SLCount = correct number of elements from S (left partition of S)
        //      which goes into the left partition of M
        // Then BLCount = correct number of elements from B (left partition of B)
        //      which goes into the left partition of M
        // Lemma: LeftPartitionSize (INVARIANT) = SLCount + BLCount;
        // Binary search to determine correct SLCount, over the smaller array to reduce time complexity
        int lowerBoundSLCount = 0, upperBoundSLCount = S.length;

        while (lowerBoundSLCount <= upperBoundSLCount) {
            // Test element counts (also partition boundaries) of both S and B
            //      which goes into LeftPartition of M
            int testSLCount = (lowerBoundSLCount + upperBoundSLCount) >> 1;
            int testBLCount = LEFTPARTITIONSIZE - testSLCount;

            // Values for the above element counts
            int SLMAX = Integer.MIN_VALUE, BLMAX = Integer.MIN_VALUE;
            int SRMIN = Integer.MAX_VALUE, BRMIN = Integer.MAX_VALUE;

            // testSLCount is size, hence rightmost value in the Left Partition of S has index testSLCount - 1
            // Guard for
            if (testSLCount - 1 >= 0) SLMAX = S[testSLCount - 1];
            // Hence, leftmost value in the Right Partition of S has index testSLCount
            // Guard for
            if (testSLCount < S.length) SRMIN = S[testSLCount];
            // testBLCount is size, hence rightmost value in the Left Partition of B has index testBLCount - 1
            // Guard for
            if (testBLCount - 1 >= 0) BLMAX = B[testBLCount - 1];
            // Hence, leftmost value in the Right Partition of B has index testBLCount
            // Guard for
            if (testBLCount < B.length) BRMIN = B[testBLCount];

            /*
             * Iteration of partitionings to find the correct symmetry:
             * Rotate top (small) and bottom (big) arrays to arrive at the correct partitioning
             *      S0, S1, S2 ... S[testSLCount - 1] or SLMAX | SRMIN or S[testSLCount], S[testSLCount + 1], ... S[S.length - 1]
             * B0, B1, B2, ....... B[testBLCount - 1] or BLMAX | BRMIN or B[testBLCount], B[testBLCount + 1], ...... B[B.length - 1]
             */

            if (SLMAX <= BRMIN && BLMAX <= SRMIN)
                return isEven ? calculateMedian(SLMAX, BLMAX, SRMIN, BRMIN) : calculateMedian(SLMAX, BLMAX);

                // Counter Clockwise rotation, take higher count of elements from S and
                //      take lower count of elements from B to maintain Left Partition Size invariant and
                //      to maintain sorted order of M
            else if (BLMAX > SRMIN) lowerBoundSLCount = testSLCount + 1;
                // Clockwise rotation, take lower count of elements from S and
                //      take higher count of elements from B to maintain Left Partition Size invariant
                //      to maintain sorted order of M
            else if (SLMAX > BRMIN) upperBoundSLCount = testSLCount - 1;
        }

        // This case is never executed.
        return 0.0;
    }

    /**
     * Calculate median of combined array M from S and B, when M.length is even.
     *
     * @param SLMAX maximum value from left partition of smaller array
     * @param BLMAX maximum value from left partition of bigger array
     * @param SRMIN minimum value from right partition of smaller array
     * @param BRMIN minimum value from right partition of bigger array
     * @return A double valued median of combined array M from S and B, when M.length is even
     */
    private static double calculateMedian(int SLMAX, int BLMAX, int SRMIN, int BRMIN) {
        return (max(SLMAX, BLMAX) + min(SRMIN, BRMIN)) / 2.0;
    }

    /**
     * Calculate median of combined array M from S and B, when M.length is odd.
     *
     * @param SLMAX maximum value from left partition of smaller array
     * @param BLMAX maximum value from left partition of bigger array
     * @return A double valued median of combined array M from S and B, when M.length is odd
     */
    private static double calculateMedian(int SLMAX, int BLMAX) {
        return max(SLMAX, BLMAX);
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        return searchLowerBound(nums, target);
    }

    public int[] searchRange(int[] nums, int target) {
        int lb = searchLowerBound(nums, target);
        int ub = searchUpperBound(nums, target);

        if (lb == nums.length || nums[lb] != target) return new int[] {-1, -1};

        return new int[] {lb, ub - 1};
    }

    public int searchLowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int lb = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                lb = mid;
                right = mid - 1;
            } else left = mid + 1;
        }

        return lb;
    }

    public int searchUpperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ub = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                ub = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ub;
    }
}
