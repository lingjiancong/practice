package com.lingjiancong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 *
 * @author lingjiancong
 * @since 2018-06-14
 */
public class BinaryTreePostorderTraversal145 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static final Boolean ALREADY_TRAVERSAL = true;
    private static final Boolean NOT_TRAVERSAL = false;

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack();
        Stack<Boolean> traversal = new Stack();

        stack.push(root);
        traversal.push(NOT_TRAVERSAL);

        while (!stack.isEmpty()) {

            boolean isTraversal = traversal.pop();
            if (isTraversal == NOT_TRAVERSAL) {
                TreeNode node = stack.peek();
                traversal.push(ALREADY_TRAVERSAL);

                if (node.right != null) {
                    stack.push(node.right);
                    traversal.push(NOT_TRAVERSAL);
                }
                if (node.left != null) {
                    stack.push(node.left);
                    traversal.push(NOT_TRAVERSAL);
                }
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1), node2 = new TreeNode(2), node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        BinaryTreePostorderTraversal145 postOrder = new BinaryTreePostorderTraversal145();
        List<Integer> result = postOrder.postorderTraversal(node1);

        result.forEach(v -> System.out.print(" " + v));
    }




}
