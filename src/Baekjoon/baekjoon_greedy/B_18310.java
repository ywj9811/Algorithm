package Baekjoon.baekjoon_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_18310 {
    private static Scanner sc = new Scanner(System.in);
    private static int cnt;
    private static List<Integer> house = new ArrayList<>();

    public static void main(String[] args) {
        cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            house.add(sc.nextInt());
        }
        Collections.sort(house);
        System.out.println(house.get((house.size()-1)/2));
    }
    //1 4 8 10 3 + 4 + 6 = 13
    //2 3 5 10 3 + 2 + 5 = 10, 1 + 2 + 7
    //1 2 3 4
    //1 3 5 7
    //1 10 20 40 71 / 4 19 + 10 + 20 49
    //1 2 11 12 13 1 10 11 12 = 34, 10 9 1 2 22
    //1 2 3 4 11 12 3 2 1 7 8 = 21 ,
    //1 2 3 4 18 55 56 57

    /**
     * 일직선으로 존재하는 여러개의 집중에 하나에만 안테나 설치
     * 안테나 부터 각 집까지의 거리의 총 합이 최소가 되도록 하자
     */
}
