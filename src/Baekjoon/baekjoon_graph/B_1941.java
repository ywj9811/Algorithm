package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] sy = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                sy[i][j] = input.charAt(j);
            }
        }

        int countY = 0;
        int countColumn = 0;
        boolean check = true;
        int cnt = 0;
        // 세5가2
        for (int i = 0; i < 5; i++) {
            countY = 0;
            for (int j = 0; j < 5; j++) {
                if (sy[j][i] == 'Y')
                    countY++;
                countColumn = countY;
            }
            for (int j = 0; j < 5; j++) {
                if (i == 1) {
                    if (sy[j][i+1] == 'Y')
                        countY++;
                    if (sy[j][i] == 'Y')
                        countY++;
                    if (countY < 4)
                        cnt++;
                }
                else if (i == 4) {
                    if (sy[j][i-1] == 'Y')
                        countY++;
                    if (sy[j][i] == 'Y')
                        countY++;
                    if (countY < 4)
                        cnt++;
                }
                else {
                    if (sy[j][i - 1] == 'Y')
                        countY++;
                    if (sy[j][i] == 'Y')
                        countY++;
                    if (countY < 4)
                        cnt++;
                    countY = countColumn;
                    if (sy[j][i+1] == 'Y')
                        countY++;
                    if (sy[j][i] == 'Y')
                        countY++;
                    if (countY < 4)
                        cnt++;
                }
            }
        }
        // 세4가3

        // 세3가4

        // 세2가5

    }
}
