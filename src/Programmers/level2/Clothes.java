package Programmers.level2;

import java.util.*;

public class Clothes {
    public static void main(String[] args) {
        new Clothes().solution(new String[][]{{"yellow_hat", "headgear"}});
    }

    public int solution(String[][] clothes) {
        Map<String, ArrayList<String>> clothMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            clothMap.putIfAbsent(clothes[i][0], new ArrayList<>());
            clothMap.get(clothes[i][1]).add(clothes[i][0]);
        }

        int sum = 1;
        Set<String> keySet = clothMap.keySet();
        for (String key : keySet) {
            sum *= (clothMap.get(key).size()+1);
        }

        return sum-1;
    }
}
