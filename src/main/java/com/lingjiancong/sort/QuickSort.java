package com.lingjiancong.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author lingjiancong
 */
public class QuickSort {

    public void quickSort(List<Integer> list) {

        if (list == null || list.size() == 0) {
            return;
        }
        quickSort(list, 0, list.size());
    }

    private void quickSort(List<Integer> list, int start, int end) {

        if (start >= end) {
            return;
        }
        int i = start, j = start + 1;
        for (; j < end; ++j) {
            if (list.get(j) < list.get(start)) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, start, i);
        quickSort(list, start, i);
        quickSort(list, i + 1, end);
    }

    private void swap(List<Integer> list, int a, int b) {
         if (a == b) {
             return;
         }
         Integer t = list.get(a);
         list.set(a, list.get(b));
         list.set(b, t);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, -1, 3, 2, 3, 2, -10, 123, 10, -12);
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(list);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
