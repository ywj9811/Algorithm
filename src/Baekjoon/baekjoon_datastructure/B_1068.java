package Baekjoon.baekjoon_datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1068 {
    static int cnt;
    static int[] parentNode;
    static boolean[] visitNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = Integer.parseInt(br.readLine());

        parentNode = new int[cnt];
        visitNode = new boolean[cnt];

        String inputParent = br.readLine();

        for (int i = 0; i < cnt; i++) {
            parentNode[i] = Integer.parseInt(inputParent.split(" ")[i]);
        }

        removeNode(Integer.parseInt(br.readLine()));

        System.out.println(countLeaf());
    }

    static void removeNode(int removeIdx) {
        visitNode[removeIdx] = true;

        for (int i = 0; i < cnt; i++) {
            if (parentNode[i] == removeIdx)
                removeNode(i);
        }
    }

    static boolean isLeaf(int idx) {
        visitNode[idx] = true;

        for (int i = 0; i < cnt; i++) {
            if (parentNode[i] == idx) {
                return false;
            }
        }

        return true;
    }

    static int countLeaf() {
        int sum = 0;

        for (int i = 0; i < cnt; i++) {
            if (visitNode[i])
                continue;

            if (isLeaf(i))
                sum++;
        }

        return sum;
    }
}