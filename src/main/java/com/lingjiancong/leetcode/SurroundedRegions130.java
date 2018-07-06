package com.lingjiancong.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped
 * to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * @author lingjiancong
 * @since 2018-07-05
 */
public class SurroundedRegions130 {

    class Node {
        int xAxis;
        int yAxis;

        public Node(int xAxis, int yAxis) {
            this.xAxis = xAxis;
            this.yAxis = yAxis;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Node)) {
                return false;
            }
            Node node = (Node) object;
            if (node.xAxis == this.xAxis && node.yAxis == this.yAxis) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return xAxis * 31 + yAxis;
        }
    }

    private Set<Node> nodes = new HashSet<>();

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int height = board.length, width = board[0].length;

        for (int i = 0; i < width; ++i) {
            traverse(board, 0, i, width, height);
            traverse(board, height- 1, i, width, height);
        }
        for (int i = 0; i < height; ++i) {
            traverse(board, i, 0, width, height);
            traverse(board, i, width - 1, width, height);
        }

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (board[i][j] == 'O') {
                    if (!nodes.contains(new Node(i, j))) {
                       board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public void traverse(char[][] board, int xAxis, int yAxis, int width, int height) {
        if (xAxis >= 0 && xAxis < height && yAxis >= 0 && yAxis < width) {

            if (board[xAxis][yAxis] == 'O') {
                if (nodes.contains(new Node(xAxis, yAxis))) {
                    return;
                }
                nodes.add(new Node(xAxis, yAxis));

                traverse(board, xAxis - 1, yAxis, width, height);
                traverse(board, xAxis, yAxis - 1, width, height);
                traverse(board, xAxis + 1, yAxis, width, height);
                traverse(board, xAxis, yAxis + 1, width, height);
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        SurroundedRegions130 regions130 = new SurroundedRegions130();
        regions130.solve(board);
    }

}
