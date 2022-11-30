package baekjoon_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class B_1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N : 듣도 못한 사람의 수
        //M : 보도 못한 사람 수
        //N, M에 모두 포함되는 사람의 수 + 사람들을 사전순으로 출력
        int N = sc.nextInt();
        int M = sc.nextInt();

        HashSet<String> nset = new HashSet<>();

        for(int i = 0; i < N; i++) {
            nset.add(sc.next());
        }

        ArrayList<String> oklist = new ArrayList<String>();
        for(int i = 0; i < M; i++){
            String tmp = sc.next();
            if (nset.contains(tmp)){
                oklist.add(tmp);
            }
        }

        Collections.sort(oklist);
        //오름차순으로 정렬

        System.out.println(oklist.size());
        for(int i = 0; i < oklist.size(); i++) {
            System.out.println(oklist.get(i));
        }

        sc.close();
    }
}