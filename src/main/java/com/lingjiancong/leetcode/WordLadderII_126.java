package com.lingjiancong.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import org.springframework.util.CollectionUtils;

/**
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 *
 * @author lingjiancong
 */
public class WordLadderII_126 {

    static class Solution {

        private int minLength = Integer.MAX_VALUE;

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            int i = wordList.indexOf(beginWord);
            if (i != -1) {
                wordList.remove(i);
            }
            wordList = randomList(wordList);
            return doFindLadders(beginWord, endWord, wordList, 1);
        }

        public List<String> randomList(List<String> wordList) {

            int len = wordList.size();

            String[] wordArray = wordList.toArray(new String[0]);

            for (int i = 0; i < len; ++i) {

                int random = (int) (Math.random() * len);
                String swapA = wordArray[random];
                wordArray[random] = wordArray[len - random - 1];
                wordArray[len - random - 1] =  swapA;
            }

            return new ArrayList(Arrays.asList(wordArray));

        }


        /**
         * beginWord = "hit"
         * endWord = "cog"
         * wordList = ["hot","dot","dog","lot","log","cog"]
         */
        public List<List<String>> doFindLadders(String beginWord, String endWord, List<String> wordList, int length) {
            if (wordList == null || !wordList.contains(endWord)) {
                return new ArrayList<>();
            }

            if (length > minLength) {
                return new ArrayList<>();
            }

            List<List<String>> result = new ArrayList<>();

            for (int i = 0, n = wordList.size(); i < n; ++i) {
                if (Objects.equals(endWord, wordList.get(i)) && differOnce(beginWord, endWord)) {
                    minLength = minLength > length + 1 ? length + 1 : minLength;
                    result = new ArrayList<>();
                    result.add(new ArrayList<>(Arrays.asList(beginWord, endWord)));
                    return result;
                }

                if (differOnce(beginWord, wordList.get(i))) {
                    List<String> newWordList = new ArrayList<>(wordList);
                    newWordList.remove(i);
                    List<List<String>> partResult = doFindLadders(wordList.get(i), endWord, newWordList, length + 1);
                    if (partResult != null && partResult.size() != 0) {
                        result.addAll(partResult);
                    }
                }
            }

            int minLen = Integer.MAX_VALUE;
            for (List<String> res : result) {
                minLen = minLen < res.size() ? minLen : res.size();
            }

            List<List<String>> minResult = new ArrayList<>();
            for (List<String> res : result) {
                if (res.size() == minLen) {
                    res.add(0, beginWord);
                    minResult.add(res);
                }
            }

            return minResult;
        }

        private boolean differOnce(String source, String target) {
            if (Objects.isNull(source) || Objects.isNull(target) || source.length() != target.length() || Objects.equals(source, target)) {
                return false;
            }
            int count = 0;
            for (int i = 0, n = source.length(); i < n; ++i) {
                if (source.charAt(i) != target.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
            return count == 1;
        }

    }


    public static void main(String[] args) {
        String begin = "qa", end = "sq";
        List<String> wordList = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));


//        String begin = "hit", end = "cog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Solution solution = new Solution();

        List<List<String>> lists = solution.findLadders(begin, end, wordList);
        if (lists != null) {
            for (List<String> list : lists) {
                if (list != null) {
                    for (String s : list) {
                        System.out.print(s + " ");
                    }
                }
                System.out.println();
            }
        }

        Queue<String> queue = new ArrayDeque<>();
    }
}
