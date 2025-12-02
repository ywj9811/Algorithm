package Baekjoon.baekjoon_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.length() < m)
                continue;
            if (map.containsKey(input)) {
                map.put(input, map.get(input)+1);
                continue;
            }
            map.put(input, 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // 정렬 기준: 1. 빈도 내림차순 2. 길이 내림차순 3. 사전순 오름차순
        list.sort((a, b) -> {
            int freq = b.getValue().compareTo(a.getValue()); // 빈도 내림차순
            if (freq != 0) return freq;
            int len = Integer.compare(b.getKey().length(), a.getKey().length()); // 길이 내림차순
            if (len != 0) return len;
            return a.getKey().compareTo(b.getKey()); // 알파벳 오름차순
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : list) {
            sb.append(e.getKey()).append('\n');
        }

        System.out.print(sb);
    }
}
