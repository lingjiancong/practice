package com.lingjiancong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * @author lingjiancong
 * @since 2018-06-14
 */
public class BinaryTreeInorderTraversal94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        do {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        } while (!stack.isEmpty() || node != null);

        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1), node2 = new TreeNode(2), node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        BinaryTreeInorderTraversal94 inorder = new BinaryTreeInorderTraversal94();
        List<Integer> result = inorder.inorderTraversal(node1);

        result.forEach(v -> System.out.print(" " + v));

    }


}
