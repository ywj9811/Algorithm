package Baekjoon.baekjoon_implement;

import java.util.Arrays;
import java.util.Scanner;

public class B_2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node[] nodes = new Node[7];
        int[] count = new int[5];
        int total = 0;

        int small_x = 0;
        int small_y = 0;

        for (int i = 0; i < 6; i++) {
            int dir = sc.nextInt();
            int len = sc.nextInt();
            count[dir]++;
            nodes[i] = new Node(dir, len);

            if (count[dir] == 2) {
                if (dir <= 2) {
                    small_x = dir;
                    continue;
                }
                small_y = dir;
            }
        }
        nodes[6] = nodes[0];

        int big_x;
        int big_y;
        if (small_x == 1)
            big_x = 2;
        else
            big_x = 1;
        if (small_y == 3)
            big_y = 4;
        else
            big_y = 3;
        int big_x_len = Arrays.stream(nodes)
                .filter(node -> node.dir == big_x)
                .findFirst()
                .get()
                .len;
        int big_y_len = Arrays.stream(nodes)
                .filter(node -> node.dir == big_y)
                .findFirst()
                .get()
                .len;
        int big_size = big_x_len * big_y_len;

        for (int i = 0; i < 6; i++) {
            int mul = nodes[i].len * nodes[i + 1].len;
            total += mul;
        }

        int result = total - (2 * big_size);

        System.out.println(result * n);
    }

    private static class Node {
        Node(int dir, int len) {
            this.dir = dir;
            this.len = len;
        }
        int dir;
        int len;
    }
}
