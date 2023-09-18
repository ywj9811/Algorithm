package Baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int startPointer=0, endPointer=0, sum=0, cnt=0;

        while(true) {
            if(sum>=m) {
                sum -= arr[startPointer++];
            }
            else if(endPointer==n)
                break;
            else {
                sum += arr[endPointer++];
            }
            if(sum==m) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}