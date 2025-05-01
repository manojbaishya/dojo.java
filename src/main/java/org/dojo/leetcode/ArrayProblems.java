package org.dojo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayProblems {
    public List<Integer> leaders(int[] arr) {
        List<Integer> l = new ArrayList<>();
        int N = arr.length;
        int max = 0;
        for (int i = N - 1; i >= 0; i--)
        {
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

    private void reverse(int[] nums, int l, int r) {
        int left = l, right = r;
        while (left < right)
        {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    private void transpose(int[][] matrix) {
        int M = matrix.length;
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < i; j++)
            {
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
