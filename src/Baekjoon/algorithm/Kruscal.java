package Baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Kruscal {
    static int leaf[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        leaf = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            leaf[i] = i;
        }

        int[][] networks = new int[m][3];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            networks[i][0] = Integer.parseInt(st.nextToken());
            networks[i][1] = Integer.parseInt(st.nextToken());
            networks[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(networks, Comparator.comparing(node -> node[2]));

        int res = 0;

        for (int[] network : networks) {
            if (union(network[0], network[1])) {
                res += network[2];
                //새로 연결했으면 그 값을 더함 과거에 연결했으면 갱신하면 최소값이 아니니 스킵
            }
        }

        System.out.println(res);
    }

    //유니온 - 파인드 알고리즘
    static int find(int a){ // 연결 끝지점 탐색
        if(a == leaf[a]) // 아직 건들지 않은 처음 상태
            return a;
        return leaf[a] = find(leaf[a]); // 자신의 끝을 찾아가는 것이다.
    }
    static boolean union(int from,int to){
        int a = find(from);
        int b = find(to);
        if(a != b) { // 연결이 없으면
            leaf[a] = b; // 연결정보가 없는 끝쪽에 갱신시켜야 연결이 안끊어짐 (중요★)
            return true;
        }
        // 이미 과거에 연결함
        return false;
    }
}
