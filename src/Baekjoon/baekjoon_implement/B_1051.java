package Baekjoon.baekjoon_implement;

import java.util.Scanner;

public class B_1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Board board = new Board(n, m);
        board.inputBoard(n, m, sc);

        SquareCalculator squareCalculator = new SquareCalculator();
        int length = squareCalculator.findMaxSquareLength(board.getBoard());

        System.out.println(length*length);
    }
}

class Board {
    private int[][] board;

    public Board(int n, int m) {
        this.board = new int[n][m];
    }

    public void inputBoard(int n, int m, Scanner sc) {
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            String[] split = input.split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }
}

class SquareCalculator {
    public int findMaxSquareLength(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int length = Math.min(n, m);

        while (length > 1) {
            for (int i = 0; i <= n - length; i++) {
                for (int j = 0; j <= m - length; j++) {
                    if (checkRec(board, i, j, length)) {
                        return length;
                    }
                }
            }
            length--;
        }
        return length;
    }

    private boolean checkRec(int[][] board, int i, int j, int length) {
        int stand = board[i][j];
        return stand == board[i+length-1][j]
                && stand == board[i][j+length-1]
                && stand == board[i+length-1][j+length-1];
    }
}
