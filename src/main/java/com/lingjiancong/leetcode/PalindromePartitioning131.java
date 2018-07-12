package com.lingjiancong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 * @author lingjiancong
 * @since 2018-07-11
 */
public class PalindromePartitioning131 {

    private List<String> currentList;

    private List<List<String>> resList;

    public List<List<String>> partition(String s) {

        currentList = new ArrayList<>();
        resList = new ArrayList<>();

        if (s == null) {
            return resList;
        }

        partitionCut(s, 0);
        return resList;
    }

    private void partitionCut(String s, int cut) {

        int len = s.length();
        if (cut > len - 1 && !currentList.isEmpty()) {
            resList.add(new ArrayList<>(currentList));
        }

        int start = cut;
        while (start < len) {
            for (int i = start; i < len; ++i) {
                if (s.charAt(cut) == s.charAt(start)) {
                    start = i;
                    break;
                }
            }
            if (isPalindrome(s, cut, start)) {
                currentList.add(s.substring(cut, start + 1));
                partitionCut(s, start + 1);
                currentList.remove(currentList.size() - 1);
            }
            ++start;
        }
    }

    private boolean isPalindrome(String s, int start, int end) {

        if (s == null) {
            return false;
        }

        int len = s.length();
        if (start >= len && end >= len && start > end && start < 0) {
            return false;
        }

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String s = "cdd";
        PalindromePartitioning131 palindromePartitioning = new PalindromePartitioning131();
        List<List<String>> res = palindromePartitioning.partition(s);
        for (List<String> ele : res) {
            System.out.println(ele);
        }
        Character.toString(s.charAt(0));
    }
}
