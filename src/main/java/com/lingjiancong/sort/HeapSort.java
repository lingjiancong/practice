package com.lingjiancong.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author lingjiancong
 */
public class HeapSort {

    public void heapSort(List<Integer> list) {
        buildMaxHeap(list);
        int heapSize = list.size();
        for (; heapSize > 1; --heapSize) {
            swap(list, 0, heapSize - 1);
            heapSort(list, 0, heapSize - 1);
        }
    }

    private void heapSort(List<Integer> list, int i, int heapSize) {
        int left = (i + 1) * 2 - 1, right = (i + 1) * 2;
        int largest = i;
        if (left < heapSize && list.get(left) > list.get(i)) {
            largest = left;
        }
        if (right < heapSize && list.get(right) > list.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            swap(list, largest, i);
            heapSort(list, largest, heapSize);
        }
    }

    private void buildMaxHeap(List<Integer> list) {
        int j = list.size() / 2 - 1;
        int heapSize = list.size();
        for (; j >= 0; --j) {
            heapSort(list, j, heapSize);
        }

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
        List<Integer> list = Arrays.asList(1, -1, 3, 2, 3, 2, -10, 123, 10, -12, -12, -21, 1, 1, 7, 89);
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(list);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
