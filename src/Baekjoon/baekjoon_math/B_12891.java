package Baekjoon.baekjoon_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12891 {
    private static int[] now = new int[4];
    private static int[] conditions = new int[4];
    private static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalLength = Integer.parseInt(st.nextToken());
        int pwLength = Integer.parseInt(st.nextToken());

        char[] inputs = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            conditions[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < pwLength; i++) {
            if (inputs[i] == 'A') {
                now[0]++;
                continue;
            }
            if (inputs[i] == 'C') {
                now[1]++;
                continue;
            }
            if (inputs[i] == 'G') {
                now[2]++;
                continue;
            }
            if (inputs[i] == 'T') {
                now[3]++;
            }
        }
        int a = 1;
        int b = a+pwLength;
        check();
        while(b <= totalLength) {
            minus(inputs[a-1]);
            add(inputs[b-1]);
            check();
            a++;
            b++;
        }

        System.out.println(cnt);
    }

    private static void add(char value) {
        if (value == 'A') {
            now[0]++;
            return;
        }
        if (value == 'C') {
            now[1]++;
            return;
        }
        if (value == 'G') {
            now[2]++;
            return;
        }
        if (value == 'T') {
            now[3]++;
        }
    }

    private static void minus(char value) {
        if (value == 'A') {
            now[0]--;
            return;
        }
        if (value == 'C') {
            now[1]--;
            return;
        }
        if (value == 'G') {
            now[2]--;
            return;
        }
        if (value == 'T') {
            now[3]--;
        }
    }

    private static void check() {
        if (now[0] >= conditions[0] && now[1] >= conditions[1] && now[2] >= conditions[2] && now[3] >= conditions[3]) {
            cnt++;
        }
    }
}
