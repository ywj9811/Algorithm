package Baekjoon.baekjoon_implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] friends = new int[t];
        boolean[][] isFriend = new boolean[t][t];

        for (int i = 0; i < t; i++) {
            List<Integer> temp = new ArrayList<>();
            String[] friend = sc.next().split("");
            for (int j = 0; j < t; j++) {
                if (friend[j].equals("Y")) {
                    temp.add(j);
                    if (!isFriend[i][j])
                        friends[i]++;
                    if (!isFriend[j][i])
                        friends[j]++;
                    isFriend[i][j] = true;
                    isFriend[j][i] = true;
                }
            }
            if (temp.size() >= 2) {
                for (int j = 0; j < temp.size(); j++) {
                    for (int value : temp) {
                        int start = temp.get(j);
                        if (!isFriend[start][value] && value != start) {
                            friends[start]++;
                            isFriend[start][value] = true;
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int count : friends) {
            if (max < count)
                max = count;
        }
        System.out.println(max);
    }
}
