package Baekjoon.baekjoon_implement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_2002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            map.put(sc.next(), i);
        }
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            arr[i] = map.get(input);
        }

        for(int i = 0; i< N-1; i++){
            for(int j = i+1; j< N; j++){
                if(arr[i] > arr[j]){
                    answer += 1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}