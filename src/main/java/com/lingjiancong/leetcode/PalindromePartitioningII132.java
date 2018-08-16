package com.lingjiancong.leetcode;

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

    public static void main(String[] args) {
        byte a = 1, b = 2;
        List<Integer> byteList = Arrays.asList(Byte.valueOf(a).intValue(), Byte.valueOf(b).intValue());
        System.out.println(byteList.contains(1));
        System.out.println(byteList.contains(new Integer(2)));

    }
}
