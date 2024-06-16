package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2667 {
    private static int N;
    private static ArrayList<Integer> aList = new ArrayList<>();
    private static int[][] arr;
    private static boolean[][] check;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());

        arr= new int [N][N];
        check= new boolean [N][N];

        for(int i=0;i<N;i++) {
            String[] s = br.readLine().split("");
            for(int j=0;j<N;j++) {
                arr[i][j]=Integer.parseInt(s[j]);
            }
        }


        int k=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(arr[i][j]==1&&!check[i][j]) {
                    aList.add(k,1);
                    dfs(i,j,k);
                    k++;
                }
            }
        }

        System.out.println(aList.size());
        Collections.sort(aList);
        for(int i : aList)
            System.out.println(i);

        br.close();

    }// main()

    private static void dfs(int x,int y,int k) {

        check[x][y]=true;

        for(int i=0;i<4;i++) {
            int tX=x+dx[i];
            int tY=y+dy[i];

            if(tX>=0 && tY>=0 &&tX<N&&tY<N) {
                if(!check[tX][tY]&&arr[tX][tY]==1) {
                    int a = aList.get(k);
                    aList.set(k,a+1);
                    dfs(tX,tY,k);
                }
            }

        }
    }


}
