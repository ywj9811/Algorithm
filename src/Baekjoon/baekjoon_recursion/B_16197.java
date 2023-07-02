package Baekjoon.baekjoon_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_16197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int column = Integer.parseInt(input.split(" ")[0]);
        int row = Integer.parseInt(input.split(" ")[1]);

        boolean board[][] = new boolean[column][row];
        List<Integer> coinRows = new ArrayList<>();
        List<Integer> coinColumns = new ArrayList<>();

        for (int i = 0; i < column; i++) {
            input = br.readLine();
            for (int j = 0; j < row; j++) {
                if (input.split("").equals("."))
                    board[i][j] = true;
                if (input.split("").equals("o")) {
                    coinRows.add(j);
                    coinColumns.add(i);
                }
                board[i][j] = false;
            }
        }

        boolean firstBoard[][];
        boolean secondBoard[][];
        int count = 0;
        boolean next = true;
        for (int i = 0; i < 4; i++) {
            while (next) {

            }
        }
    }
}
