package com.lingjiancong.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * @author lingjiancong
 */
public class WordLadderII_126 {

    static class Solution {

        Map<String, List<List<String>>> path = new HashMap<>();

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            int i = wordList.indexOf(beginWord);
            if (i != -1) {
                wordList.remove(i);
            }
            return findLaddersWithoutBeginWord(beginWord, endWord, wordList);
        }


        /**
         * beginWord = "hit"
         * endWord = "cog"
         * wordList = ["hot","dot","dog","lot","log","cog"]
         */
        public List<List<String>> findLaddersWithoutBeginWord(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || !wordList.contains(endWord)) {
                return new ArrayList<>();
            }

            List<List<String>> result = new ArrayList<>();

            for (int i = 0, n = wordList.size(); i < n; ++i) {
                List<List<String>> partResult = null;
                if (Objects.equals(endWord, wordList.get(i)) && differOnce(beginWord, endWord)) {
                    partResult = new ArrayList<>();
                    partResult.add(new ArrayList<>(Arrays.asList(beginWord, endWord)));
                } else if (differOnce(beginWord, wordList.get(i))) {
                    List<String> newWordList = new ArrayList<>(wordList);
                    newWordList.remove(i);
                    partResult = findLaddersWithoutBeginWord(wordList.get(i), endWord, newWordList);
                    if (partResult != null) {
                        for (List<String> res : partResult) {
                            res.add(0, beginWord);
                        }
                    }
                }
                if (partResult != null) {
                    result.addAll(partResult);
                }
            }

            int minLen = Integer.MAX_VALUE;
            for (List<String> res : result) {
                if (res.size() < minLen) {
                    minLen = res.size();
                }
            }

            List<List<String>> minResult = new ArrayList<>();
            for (List<String> res : result) {
                if (res.size() == minLen) {
                    minResult.add(res);
                }
            }
            path.put(beginWord, minResult);
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

        private List<List<Boolean>> createDifferOnceMatrix(List<String> wordList) {
            if (Objects.isNull(wordList)) {
                return null;
            }
            List<List<Boolean>> matrix = new ArrayList<>();
            for (int i = 0, n = wordList.size(); i < n; ++i) {
                List<Boolean> row = new ArrayList<>();
                String source = wordList.get(i);
                for (int j = 0; j < n; ++j) {
                    row.add(differOnce(source, wordList.get(j)));
                }
                matrix.add(row);
            }
            return matrix;
        }
    }


    public static void main(String[] args) {
//        String begin = "qa", end = "sq";
//        List<String> wordList = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));

        String begin = "hit", end = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
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
