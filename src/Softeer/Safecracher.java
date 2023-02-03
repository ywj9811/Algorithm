package Softeer;

import java.util.*;

public class Safecracher {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalValue = 0;

        int bagWeight = sc.nextInt();
        int kinds = sc.nextInt();

        int[] jewelWeight = new int[kinds];
        int[] jewelValue = new int[kinds];
        for (int i = 0; i < kinds; i++) {
            jewelWeight[i] = sc.nextInt();
            jewelValue[i] = sc.nextInt();
        }

        quicksort(jewelValue, jewelWeight, 0, kinds-1);

        for (int i = jewelValue.length - 1; i >= 0; i--) {
            if (jewelWeight[i] >= bagWeight) {
                totalValue += jewelValue[i] * bagWeight;
                break;
            }

            totalValue += jewelValue[i] * jewelWeight[i];
            bagWeight -= jewelWeight[i];

            if (bagWeight <= 0)
                break;
        }

        System.out.println(totalValue);
    }
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }//두개 -> pl과 pr을 교체하기위한 메소드

    static void quicksort(int[]a, int[]b, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr)/2]; //x를 피봇으로, 왼쪽 오른쪽 합의 /2

        do {
            while(a[pl] < x)
                pl++; //피봇보다 작다면 계속해서 늘려감, 그러다가 큰값이 나오는 순간 pl고정
            while(a[pr] > x)
                pr--; //피봇보다 크다면 계속해서 줄여나감, 작은값이 나오는 순간 pr고정
            if(pl <= pr) {
                swap(a, pl, pr);//swap과정을 마치고 반복조건 성립하면 위에서부터 다시
                swap(b, pl++, pr--);
            }
        }while(pl <= pr); //pl과 pr이 교차할때까지

        if(left < pr)
            quicksort(a, b, left, pr);
        if(right > pl)
            quicksort(a, b, pl, right); //while을 탈출한 이상 pl은 pr보타 오른쪽에 위치하게 되어있음 혹은 동일
    }
}
