package com.lingjiancong.leetcode;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * @author lingjiancong
 * @since 2018-08-08
 */
public class PalindromePartitioningII132 {


    public int minCut(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] minCutRecords = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            minCutRecords[i] = Integer.MAX_VALUE;
        }

        return minCut(s, 0, s.length(), minCutRecords);
    }

    public int minCut(String s, int start, int end, int[] mintCutRecords) {

        if (s == null || start >= end || start < 0 || end > s.length() || isPalindrome(s, start, end)) {
            return 0;
        }

        int size = end - start;
        int minCut = size - 1;

        for (int i = start + 1; i < end; ++ i) {
            if (isPalindrome(s, start, i)) {
                int rightMinCut = mintCutRecords[i] == Integer.MAX_VALUE ? minCut(s, i, end, mintCutRecords) : mintCutRecords[i];
                minCut = minCut > rightMinCut + 1 ? rightMinCut + 1 : minCut;
            }
        }

        if (minCut < mintCutRecords[start]) {
            mintCutRecords[start] = minCut;
        }
        return minCut;
    }


    /**
     * @param s
     * @param start inclusive
     * @param end exclusive
     * @return
     */
    public boolean isPalindrome(String s, int start, int end) {
        int size = s.length();
        if (start >= end || start < 0 || end > size) {
            return false;
        }

        for (int i = start, j = end - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        String s = "aab";
        PalindromePartitioningII132 palindromePartitioning = new PalindromePartitioningII132();

        System.out.println(palindromePartitioning.minCut(s));


    }
}
