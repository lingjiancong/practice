package com.lingjiancong.leetcode;

import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * @author lingjiancong
 * @since 2018-06-13
 */
public class SumRootToLeafNumbers129 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        int sum = 0, pathNum = 0, height = 0;

        TreeNode node = root;

        do {
            while (node != null) {
                height++;
                stack.push(node);
                stackNum.push(height);

                pathNum = pathNum * 10 + node.val;
                node = node.left;
            }

            node = stack.pop();
            int tHeight = stackNum.pop();

            pathNum = truncate(pathNum, tHeight);
            height = tHeight;
            if (node.left == null && node.right == null) {
                sum += pathNum;
            }
            node = node.right;
        } while (!stack.isEmpty() || node != null);

        return sum;

    }

    public int truncate(int num, int len) {
        int curLen = 0, t = num;
        while (t!= 0) {
            t = t/ 10;
            curLen++;
        }
        int diff = curLen - len;
        if (diff < 0) {
            return 0;
        }
        for (int i = 0; i < diff; ++i) {
            num = num / 10;
        }
        return num;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0), node2 = new TreeNode(1), node3 = new TreeNode(3);
        node1.left = node2;

        SumRootToLeafNumbers129 sum = new SumRootToLeafNumbers129();
        System.out.println(sum.sumNumbers(node1));
    }


}
