package Baekjoon.baekjoon_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1715 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			queue.add(sc.nextInt());
		}

		int sum = 0;
		int now = 0;

		if (n == 1) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			Integer first = queue.poll();
			Integer second = 0;
			if (!queue.isEmpty()) {
				second = queue.poll();
			}
			now = first+second;
			sum += now;
			if (!queue.isEmpty())
				queue.add(now);
		}

		System.out.println(sum);
	}
}
