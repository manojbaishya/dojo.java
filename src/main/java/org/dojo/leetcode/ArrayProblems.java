package org.dojo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ArrayProblems {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        int left = l, right = r;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     * Variable Size Sliding Window solution.
     *
     * @param target the target sum
     * @param nums   the input array
     * @return minimum length of subarray with the sum >= target
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];

            while (windowSum >= target) {
                windowSum -= nums[start];
                minLength = Math.min(minLength, end + 1 - start);
                start++;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeSubarrays(arr, left, mid, right);
    }

    private static void mergeSubarrays(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;

        List<Integer> tmp = new ArrayList<>(right + 1 - left);

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tmp.add(arr[l]);
                l++;
            } else {
                tmp.add(arr[r]);
                r++;
            }
        }

        while (l <= mid) {
            tmp.add(arr[l]);
            l++;
        }

        while (r <= right) {
            tmp.add(arr[r]);
            r++;
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp.get(i - left);
        }
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partitionByPivot(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partitionByPivot(int[] arr, int left, int right) {
        int pivot = medianOfThree(arr, left, right);

        swap(arr, left, pivot);
        pivot = left;

        int i = left;
        int j = right;
        while (i < j) {
            while (arr[i] <= arr[pivot] && i < right) i++;
            while (arr[j] > arr[pivot] && j > left) j--;

            if (i < j) swap(arr, i, j);
        }

        if (arr[pivot] >= arr[j]) {
            swap(arr, left, j);
            pivot = j;
        }

        return pivot;
    }


    private static int medianOfThree(int[] arr, int left, int right) {
        if (right - left == 1) return arr[left] <= arr[right] ? left : right;

        int mid = left + (right - left) / 2;
        int a = arr[left], b = arr[mid], c = arr[right];

        if ((a > b) ^ (a > c)) return left;
        if ((b < a) ^ (b < c)) return mid;
        return right;
    }

    public int largest(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : arr) {
            if (integer >= max) max = integer;
        }
        return max;
    }

    public int getSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int midx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                midx = i;
                max = arr[i];
            }
        }

        swap(arr, 0, midx);

        int secMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != max && arr[i] >= secMax) secMax = arr[i];
        }

        return secMax != Integer.MIN_VALUE ? secMax : -1;
    }

    public boolean checkSortAndRotation(int[] nums) {
        int troughs = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] >= nums[i]) continue;
            else troughs++;
            if (troughs > 1) break;
        }

        if (troughs == 0) return true;
        if (troughs == 1 && nums[nums.length - 1] <= nums[0]) return true;
        return false;
    }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        List<Integer> indices = new ArrayList<>(nums.length);
        indices.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                indices.add(i);
                j = i;
            }
        }

        for (int k = 0; k < indices.size(); k++) {
            nums[k] = nums[indices.get(k)];
        }

        return indices.size();
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
            i++;
        }

        return j + 1;
    }

    public void rotate(int[] nums, int k) {
        int m = k;
        if (k >= nums.length) m = k % nums.length;
        int[] tmp = new int[m];
        int N = nums.length;
        for (int i = N - m; i < N; i++) {
            tmp[i - (N - m)] = nums[i];
        }

        for (int i = N - m - 1; i >= 0; i--) {
            nums[i + m] = nums[i];
        }

        for (int i = 0; i < m; i++) {
            nums[i] = tmp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        int N = nums.length;
        int m = k;
        if (k >= N) m = k % N;

        reverse(nums, 0, N - 1);
        reverse(nums, 0, m - 1);
        reverse(nums, m, N - 1);
    }

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }

        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

    public boolean linearSearch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == k) return true;
        return false;
    }

    public int[] findUnion(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>();
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public int missingNumber(int[] nums) {
        int N = nums.length;
        int cmpSum = N * (N + 1) / 2;
        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) actualSum += nums[i];
        return cmpSum - actualSum;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int S = 0;
        int L = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 1) L++;
            else L = 0;
            if (L != 0) S = Math.max(S, L);
        }

        return S;
    }

    public int singleNumber(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }

    public int longestSubarraySum(int[] arr, int k) {
        int maxLength = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum == k) {
                maxLength = Math.max(maxLength, end + 1 - start);
                sum -= arr[start];
                start++;
            }
        }

        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }

    public int longestSubarraySumPrefix(int[] arr, int k) {
        int[] sums = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++)
            sums[i + 1] = sums[i] + arr[i];

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;

        for (int j = 0; j < arr.length; j++) {
            int currentSum = sums[j + 1];

            if (currentSum == k)
                maxLength = Math.max(maxLength, j + 1);

            if (prefixSumMap.containsKey(currentSum - k))
                maxLength = Math.max(maxLength, j - prefixSumMap.get(currentSum - k));

            if (!prefixSumMap.containsKey(currentSum))
                prefixSumMap.put(currentSum, j);
        }

        return maxLength;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
                default:
                    continue;
            }
        }

        int j = 0;
        while (j < red) {
            nums[j] = 0;
            j++;
        }
        while (j < red + white) {
            nums[j] = 1;
            j++;
        }
        while (j < red + white + blue) {
            nums[j] = 2;
            j++;
        }
    }

    public void sortColorsDutchNationalFlag(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, right, mid);
                right--;
            }
        }
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }
        return 0;
    }

    public int majorityElementMoore(int[] nums) {
        int element = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) element = nums[i];

            if (nums[i] == element) count++;
            else count--;
        }

        if (count == 0) return 0;

        int freq = 0;
        for (int i = 0; i < nums.length; i++) if (nums[i] == element) freq++;

        if (freq > nums.length / 2) return element;
        else return 0;
    }

    public int maxSubArraySumKadane(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int start = -1, subStart = -1, subEnd = -1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
                subStart = start;
                subEnd = i;
            }

            if (sum < 0) sum = 0;
        }

        return maxSum != Integer.MIN_VALUE ? maxSum : 0;
    }

    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int profit = 0;
        int checkProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            checkProfit = prices[i] - minBuy;
            profit = Math.max(checkProfit, profit);
            minBuy = Math.min(prices[i], minBuy);
        }

        return profit;
    }

    public int[] rearrangeArrayAlternateSigns(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];

        int j = 0, k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos[k] = nums[i];
                k++;
            } else {
                neg[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i];
        }

        return nums;
    }

    public void nextPermutation(int[] nums) {
        int N = nums.length;

        int k = N - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) k--;

        if (k == -1) {
            reverse(nums, 0, N - 1);
            return;
        }

        int l = N - 1;
        while (l >= 0 && nums[k] >= nums[l]) l--;

        swap(nums, l, k);

        reverse(nums, k + 1, N - 1);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int num : set) {
            if (set.contains(num - 1)) continue;

            int nextNum = num;
            while (set.contains(nextNum)) {
                cnt++;
                nextNum++;
            }

            max = Math.max(max, cnt);
            cnt = 0;
        }

        return max;
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        int M = matrix.length;
        int N = matrix[0].length;

        int col0 = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < N; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public List<Integer> leaders(int[] arr) {
        List<Integer> l = new ArrayList<>();
        int N = arr.length;
        int max = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] >= max) l.add(arr[i]);
            max = Math.max(max, arr[i]);
        }
        Collections.reverse(l);
        return l;
    }

    public void rotateImage(int[][] matrix) {
        if (matrix.length == 0) return;
        int N = matrix[0].length;

        // Transpose the matrix
        transpose(matrix);

        // Reverse each row of the matrix
        for (int[] ints : matrix) {
            reverse(ints, 0, N - 1);
        }
    }



    private void transpose(int[][] matrix) {
        int M = matrix.length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int left = findEnd(nums, target, "Left");
        int right = findEnd(nums, target, "Right");
        return new int[] {left, right};
    }

    private int findEnd(int[] nums, int target, String end) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (end.equals("Left"))
                    right = mid - 1;
                else if (end.equals("Right"))
                    left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
