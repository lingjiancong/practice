package com.lingjiancong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

/**
 * @author lingjiancong
 */
public class QuickSort {

    public void quickSort(List<Integer> array, int start, int end) {
        if (array == null || array.isEmpty()) {
            return;
        }
        if (start >= end - 1) {
            return;
        }

        int x = array.get(start), i = start + 1, j = start + 1;

        while (j < end) {
            if (x >= array.get(j)) {
                swap(array, i, j);
                i++;
            }
            j++;
        }
        swap(array, start, i - 1);
        quickSort(array, start, i - 1);
        quickSort(array, i, end);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 4, 3, 2, 1, 3, -45, 0, 54, 323, 9, 23, 12, 45));
        QuickSort sort = new QuickSort();
        sort.quickSort(list, 0, list.size());

        for (Integer i : list) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
