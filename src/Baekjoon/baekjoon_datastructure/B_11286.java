package Baekjoon.baekjoon_datastructure;

import java.io.IOException;
import java.util.*;

public class B_11286 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int absO1 = Math.abs(o1);
                int absO2 = Math.abs(o2);
                if (absO1 > absO2) {
                    return 1;
                }
                if (absO1 < absO2) {
                    return -1;
                }
                return o1 - o2;
            }
        });

        int total = sc.nextInt();
        for (int i = 0; i < total; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(queue.poll());
                continue;
            }
            queue.add(input);
        }
    }
}
