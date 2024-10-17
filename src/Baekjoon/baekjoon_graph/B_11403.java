package Baekjoon.baekjoon_graph;

import java.util.Scanner;

public class B_11403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Possible possible = new Possible(sc.nextInt());
        possible.makeBoard(sc);

        Calculate calculate = new Calculate(possible);
        calculate.calPossible();

        possible.printBoard();
    }
}

class Possible {
    private int[][] board;

    public Possible(int size) {
        board = new int[size][size];
    }

    public void makeBoard(Scanner sc) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void updateBoard(int x, int y, int value) {
        board[x][y] = value;
    }

    public boolean checkPossible(int x, int y) {
        return board[x][y] == 1;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Calculate {
    private Possible possible;

    public Calculate(Possible possible) {
        this.possible = possible;
    }

    public void calPossible() {
        int[][] board = possible.getBoard();
        for (int i = 0; i < board.length; i++) { // 경유지
            for (int j = 0; j < board.length; j++) { // 출발지
                for (int k = 0; k < board.length; k++) { // 도착지
                    if (possible.checkPossible(j, i) && possible.checkPossible(i, k)) {
                        possible.updateBoard(j, k, 1);
                    }
                }
            }
        }
    }
}