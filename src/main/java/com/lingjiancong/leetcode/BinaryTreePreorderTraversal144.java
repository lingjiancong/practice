package com.lingjiancong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * @author lingjiancong
 * @since 2018-06-11
 */
public class BinaryTreePreorderTraversal144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();


        if (root == null) {
            return result;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();

        while (temp != null) {
            result.add(temp.val);
            stack.push(temp);
            temp = temp.left;
        }

        while (!stack.isEmpty()) {
            temp = stack.pop();

            temp = temp.right;
            while (temp != null) {
                result.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            }

        }
        return result;
    }
}
