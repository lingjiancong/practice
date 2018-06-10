package com.lingjiancong.topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lingjiancong
 */
public class WordFind {

    public static final int CHARACTER_SIZE = 26;

    private Trie root;

    public void init() {
        root = new Trie();
        root.init();
    }

    public void addWord(Trie vertex, String word) {
        if (word == null || vertex == null || vertex.isEmpty()) {
            return;
        } else if (word.isEmpty()) {
            vertex.words++;
        } else {
            int k = (word.charAt(0) - 'A');
            if (vertex.edges.get(k).isEmpty()) {
                Trie trie = new Trie();
                trie.init();
                vertex.edges.set(k, trie);
            }
            vertex.prefixes++;
            addWord(vertex.edges.get(k), word.substring(1));
        }
    }

    private Boolean match(Trie vertex, String word) {
        if (vertex == null || word == null || vertex.isEmpty()) {
            return false;
        } else if (word.isEmpty()) {
            return vertex.words > 0;
        }
        int k = word.charAt(0) - 'A';
        return match(vertex.edges.get(k), word.substring(1));
    }

    public List<String> findWords(List<String> grid, List<String> wordList) {
        if (grid == null || grid.isEmpty() || wordList == null || wordList.isEmpty()) {
            return new ArrayList<>();
        }

        int length = grid.get(0).length();
        if (length == 0) {
            return new ArrayList<>();
        }
        int size = grid.size();

        // right
        addWord(root, grid.get(0));
        // down
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            sb.append(grid.get(i).charAt(0));
        }
        addWord(root, sb.toString());
        // down right
        sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (i < length && i < size) {
                sb.append(grid.get(i).charAt(i));
            }
        }
        addWord(root, sb.toString());

        // horizontal
        for (int i = 1; i < length; ++i) {
            // down
            sb = new StringBuilder();
            for (int j = 0; j < size; ++j) {
                sb.append(grid.get(j).charAt(i));
            }
            addWord(root, sb.toString());
            // down right
            int k = i;
            sb = new StringBuilder();
            for (int j = 0; j < size; ++j) {
                if (k < length) {
                    sb.append(grid.get(j).charAt(k));
                    ++k;
                }
            }
            addWord(root, sb.toString());
        }

        // vertical
        for (int i = 1; i < size; ++i) {
            // right
            addWord(root, grid.get(i));
            // down right
            sb = new StringBuilder();
            int k = 0;
            for (int j = i; j < size; ++j) {
                if (k < length) {
                    sb.append(grid.get(j).charAt(k));
                    k++;
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordList.size(); ++i) {
            boolean value = match(root, wordList.get(i));
            res.add(String.valueOf(value));
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> grid = Arrays.asList("TEST", "GOAT", "BOAT");
        List<String> wordList = Arrays.asList("GOAT", "BOAT", "TEST");

        WordFind wordFind = new WordFind();
        wordFind.init();
        List<String> res = wordFind.findWords(grid, wordList);
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
    }
}

class Trie {
    Integer words;
    Integer prefixes;
    List<Trie> edges;

    public void init() {
        this.words = 0;
        this.prefixes = 0;
        edges = new ArrayList<>();
        for (int i = 0; i < WordFind.CHARACTER_SIZE; ++i) {
            this.edges.add(new EmptyTrie());
        }
    }

    public Boolean isEmpty() {
        return this.getClass().equals(EmptyTrie.class);
    }
}

class EmptyTrie extends Trie {
}
