package Baekjoon.baekjoon_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String line;
        int total = 0;
        while ((line = br.readLine()) != null) {
            total++;
            int value = map.getOrDefault(line, 0);
            value++;
            map.put(line, value);
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            int count = map.get(key);
            double percent = (count * 100.0) / total;
            System.out.printf("%s %.4f%n", key, percent);
        }

    }
}
