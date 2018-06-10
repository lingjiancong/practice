package com.lingjiancong.interview;

import java.util.Arrays;
import java.util.List;

/**
 * @author lingjiancong
 */
public class HeapSort {

    public List<Integer> sort(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return arr;
        }

        int size = arr.size();
        buildMaxHeap(arr, size);

        swap(arr, 0, size - 1);

        for (int i = size - 1; i > 1; --i) {
            maxHeap(arr, i, 0);
            swap(arr, 0, i - 1);
        }

        return arr;
    }

    public void buildMaxHeap(List<Integer> arr, Integer arrLen) {
        int end = arrLen / 2 - 1;
        for (int i = end; i >= 0; --i) {
            maxHeap(arr, arrLen, i);
        }
    }

    public void maxHeap(List<Integer> arr, Integer arrLen, Integer index) {
        int left = index * 2 + 1, right = index * 2 + 2;
        int max = index;
        if (left < arrLen && arr.get(left) > arr.get(max)) {
            max = left;
        }
        if (right < arrLen && arr.get(right) > arr.get(max)) {
            max = right;
        }
        swap(arr, max, index);
        if (max != index && max < arrLen / 2) {
            maxHeap(arr, arrLen, max);
        }
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
        List<Integer> arr = Arrays.asList(1, 4, 5, 3, 101, 100, -1, -109, 100);

        HeapSort heapSort = new HeapSort();

        arr = heapSort.sort(arr);

        for (int i = 0; i < arr.size(); ++i) {
            System.out.print(" " + arr.get(i));
        }
        System.out.println();
    }
}
