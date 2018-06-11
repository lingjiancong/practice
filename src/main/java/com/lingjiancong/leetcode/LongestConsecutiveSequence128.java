package com.lingjiancong.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * @author lingjiancong
 * @since 2018-06-08
 */
public class LongestConsecutiveSequence128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        if (nums == null) {
            return 0;
        }
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for (int num : nums) {
            int currentLen = 1;

            int temp = num;
            if (!set.contains(temp - 1)) {

                while (set.contains(temp + 1)) {
                    currentLen++;
                    temp++;
                }
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence128 sequence = new LongestConsecutiveSequence128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int len = sequence.longestConsecutive(nums);
        System.out.println(len);
    }


}
