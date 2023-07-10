package Baekjoon.baekjoon_datastructure;

import java.util.*;

public class B_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Queue<Integer> card = new LinkedList<>();

        for (int i = 1; i <= input; i++) {
            card.add(i);
        }

        while (card.size() > 1) {
            card.poll();
            card.add(card.poll());
        }

        System.out.println(card.poll());
    }
}
