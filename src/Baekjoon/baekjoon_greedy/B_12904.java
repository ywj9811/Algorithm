package Baekjoon.baekjoon_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_12904 {
    public static void main(String[] args) throws IOException {
        // A추가
        // 뒤집고 B추가
        // 가능 1 불가능 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuffer t = new StringBuffer(br.readLine());
        int loop = t.length();
        for (int i = 0; i < loop; i++) {
            if (t.charAt(t.length() - 1) == 'B') {
                t = t.deleteCharAt(t.length() - 1);
                t = t.reverse();
                if (t.toString().equals(s)) {
                    System.out.println(1);
                    return;
                }
                continue;
            }
            t = t.deleteCharAt(t.length() - 1);
            if (t.toString().equals(s)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
        //오직 B는 안됨
        //t -> s 이렇게 진행
        //맨 뒤가 A -> 제거
        //맨 뒤가 b -> 제거 동시에 뒤집어
        //ABBBA
        //ABBB
        //BBA
        //BB
        //B

        br.close();
    }
}
