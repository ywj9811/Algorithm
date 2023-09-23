package Baekjoon.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        int n = 4;
        int[][] nationality = {{1,2}, {2,3}, {1,3}};

        List<List<Integer>> national = new ArrayList<>();

        Arrays.sort(nationality, Comparator.comparingInt((int[] o) -> o[0]));
        out : for (int i = 0; i < nationality.length; i++) {
            for (List<Integer> a : national) {
                if (a.contains(nationality[i][0]) && a.contains(nationality[i][1]))
                    continue out;
                if (a.contains(nationality[i][0])) {
                    a.add(nationality[i][1]);
                    continue out;
                }
                if (a.contains(nationality[i][1])) {
                    a.add(nationality[i][0]);
                    continue out;
                }
            }
            List<Integer> create = new ArrayList<>();
            create.add(nationality[i][0]);
            create.add(nationality[i][1]);
            national.add(create);
        }
        out : for (int i = 1; i <= n; i++) {
            for (List<Integer> a : national) {
                if (a.contains(i))
                    continue out;
            }
            List<Integer> create = new ArrayList<>();
            create.add(i);
            national.add(create);
        }

        if (national.size() == 1) {
            System.out.println(0);
            return;
        }
        int sum = 0;
        for (int i = 0; i < national.size()-1; i++) {
            for (int j = i+1; j < national.size(); j++) {
                sum += national.get(i).size() * national.get(j).size();
            }
        }
        System.out.println(sum);
    }
}
