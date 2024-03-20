package Programmers.cote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    static int min = Integer.MAX_VALUE;
    static int[] origin;
    static int[] result;
    static boolean[] check;
    static int[] orders;
    static int n;

    /**
     * n이 총 개수 -> n = 3 -> 11 22 33 6개 하지만 1 2 3 이렇게 묶음은 같이 정렬
     * orders가 주문 들어오는 것들
     *
     * orders 에 따라서 하나씩 뽑는데 위의 개수만큼 힘이 필요. 최소의 힘을 구해라
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        orders = new int[]{1,1,2,2,3,3,4,4,5,5,10,10,6,6,7,7,8,8,9,9};
        origin = new int[n];
        for (int i = 1; i <= n; i++) {
            origin[i-1] = i;
        }
        result = new int[n];
        check = new boolean[n];

        dfs(0);

        System.out.println(min%1000000000);
    }

    static void howMuch(List<Integer> real) {
        int sum = 0;
        for (int i = 0; i < orders.length; i++) {
            int cnt = 0;
            for (int j = 0; j < real.size(); j++) {
                if (orders[i] == real.get(j)) {
                    sum += cnt;
                    real.remove(j);
                    break;
                }
                cnt++;
            }
            if (sum > min)
                break;
        }

        min = Math.min(sum, min);
    }

    static void dfs(int level) {
        if (level == n) {
            List<Integer> real = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                real.add(result[i]);
                real.add(result[i]);
            }
            howMuch(real);
            return;
        }
        for(int i=0; i<n; i++) {
            if (!check[i]) {
                check[i] = true;
                result[level] = origin[i];
                dfs(level+1);
                check[i]=false;
            }
        }
    }
}

