package Baekjoon.baekjoon_greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_19941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> ham = new ArrayList<>();
        List<Integer> peo = new ArrayList<>();

        String input = sc.next();
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'H') {
                ham.add(i);
            } else {
                peo.add(i);
            }
        }

        int i = 0;
        int j = 0;
        int result = 0;

        while (i < ham.size() && j < peo.size()) {
            int hdx = ham.get(i);
            int pdx = peo.get(j);
            if (Math.abs(hdx - pdx) > k) {
                if (hdx - pdx > k) {
                    j++;
                    continue;
                } else {
                    i++;
                    continue;
                }
            }
            result++;
            i++;
            j++;
        }

        System.out.println(result);
    }
}
