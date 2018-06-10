package com.lingjiancong.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lingjiancong
 */
public class CC extends FF {

    @Override
    @Test
    public void test() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4);
        List<List<Integer>> res = getCombination(arr, 2);
        for (List<Integer> sub : res) {
            for (Integer i : sub) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
        return;
    }

    public List<List<Integer>> getCombination(List<Integer> arr, int m) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.size() < m) {
            return res;
        }
        List<Integer> pro = new ArrayList<>();
        getCombination(arr, res, pro, m, 0);
        return res;
    }

    public void getCombination(List<Integer> arr, List<List<Integer>> res, List<Integer> pro, int m, int index) {
        if (pro.size() == m) {
            res.add(pro);
            return;
        }
        if (pro.size() + arr.size() - index < m) {
            return;
        }
        int num = arr.get(index);

        getCombination(arr, res, new ArrayList<Integer>(pro), m, index + 1);
        pro.add(num);
        getCombination(arr, res, pro, m, index + 1);

    }


}
