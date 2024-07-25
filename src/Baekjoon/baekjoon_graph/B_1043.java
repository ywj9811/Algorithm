package Baekjoon.baekjoon_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1043 {
    private static ArrayList<Integer>[] parties, participantsIn;
    private static int[] knownPeople;
    private static boolean[] canLie;

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);

        //사람 - 참가 파티, 파티 - 참가자, 파티 결과 자료구조 초기화
        int N = sc.nextInt();
        int M = sc.nextInt();

        parties = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            parties[i] = new ArrayList<>();
        }
        participantsIn = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            participantsIn[i] = new ArrayList<>();
        }
        canLie = new boolean[M];

        //진실을 아는 사람 저장
        int knownPeopleNum = sc.nextInt();
        knownPeople = new int[knownPeopleNum];

        for (int i = 0; i < knownPeopleNum; i++) {
            knownPeople[i] = sc.nextInt();
        }

        //파티-참가자, 참가자-파티 저장
        for (int party = 0; party < M; party++) {
            int peopleNum = sc.nextInt();

            for (int j = 0; j < peopleNum; j++) {
                int person = sc.nextInt();

                parties[person].add(party);
                participantsIn[party].add(person);
            }
        }

        //dfs
        for (int i = 0; i < knownPeople.length; i++) {
            dfs(knownPeople[i]);
        }

        for (int i = 0; i < canLie.length; i++) {
            if (!canLie[i]) {
                ++answer;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int person) {//dfs 기반 탐색
        for (int i = 0; i < parties[person].size(); i++) {
            int party = parties[person].get(i);

            if (!canLie[party]) {
                canLie[party] = true;

                for (int j = 0; j < participantsIn[party].size(); j++) {
                    int nextPerson = participantsIn[party].get(j);
                    dfs(nextPerson);
                }
            }
        }
    }
}
