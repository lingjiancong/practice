package com.lingjiancong.interview;

import java.util.Arrays;
import java.util.List;

/**
 * @author lingjiancong
 */
public class QuickSort {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return arr;
        }
        quickSort(arr, 0, arr.size());
        return arr;
    }

    private void quickSort(List<Integer> arr, Integer begin, Integer end) {
        if (end <= begin) {
            return;
        }
        int j = begin, i = begin + 1;
        int value = arr.get(begin);
        for (; i < end; ++i) {
           if (arr.get(i) < value) {
               j++;
               swap(arr, j, i);
           }
        }
        swap(arr, j, begin);
        quickSort(arr, begin, j);
        quickSort(arr, j + 1, end);
    }

    public void swap(List<Integer> arr, Integer a, Integer b) {
        if (a.equals(b)) {
            return;
        }
        int value = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, value);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, -1, -34, 56);

        QuickSort sort = new QuickSort();

        arr = sort.sort(arr);

        for (int i = 0; i < arr.size(); ++i) {
            System.out.print(" " + arr.get(i));
        }
        System.out.println();
    }
}
