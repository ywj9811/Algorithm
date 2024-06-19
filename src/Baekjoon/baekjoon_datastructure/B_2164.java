package Baekjoon.baekjoon_datastructure;

import java.util.*;

public class B_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            Integer re = queue.poll();
            queue.add(re);
        }

        System.out.println(queue.poll());
    }
}
