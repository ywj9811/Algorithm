package Baekjoon.baekjoon_datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if(abs1 == abs2) return o1 > o2 ? 1 : -1;
                return abs1 - abs2;
            }
        });

        int inputCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < inputCount; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll() + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}
