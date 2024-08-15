package Baekjoon.baekjoon_greedy;

import java.util.*;

public class B_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> nums = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        List<Integer> removes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        Collections.sort(nums);

        if (nums.size() <= 1) {
            System.out.println(nums.stream().mapToInt(a -> a).sum());
            return;
        }


        for (int i = nums.size()-1; i >= 1; i -= 2) {
            Integer first = nums.get(i);
            if (i-1 < 0)
                break;
            Integer second = nums.get(i - 1);
            if (first < 1)
                break;
            if (first > 1 && second > 1) {
                ans.add(first * second);
                removes.add(i);
                removes.add(i-1);
            }
        }

        for (int i = 0; i < nums.size(); i += 2) {
            Integer first = nums.get(i);
            if (i+1 >= nums.size())
                break;
            Integer second = nums.get(i + 1);
            if (first > 0)
                break;
            if (first <= 0 && second <= 0) {
                ans.add(first * second);
                removes.add(i);
                removes.add(i+1);
            }
        }

        removes.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int idx : removes) {
            nums.remove(idx);
        }

        int sum = ans.stream().mapToInt(a -> a).sum();
        int another = nums.stream().mapToInt(a -> a).sum();
        System.out.println((sum + another));
    }
}
