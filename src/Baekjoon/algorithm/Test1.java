package Baekjoon.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
    static String s = "aaaababab";
    static String[] word_dict = {"aaa", "aaaa", "ab", "bab", "aababa"};
    static Queue<CheckSum> q = new LinkedList<>();

    public static void main(String[] args) {
        char start = s.charAt(0);
        for (int i = 0; i < word_dict.length; i++) {
            if (word_dict[i].charAt(0) == start) {
                String substring = s.substring(0, word_dict[i].length());
                if (substring.equals(word_dict[i])) {
                    q.add(new CheckSum(word_dict[i], 1));
                }
            }
        }

        int max = check();
        System.out.println(max);
    }

    static int check() {
        int max = 1;
        while (!q.isEmpty()) {
            CheckSum poll = q.poll();
            String dictString = poll.getDictString();
            if (dictString.length() > s.length()) {
                continue;
            }
            if (dictString.equals(s)) {
                System.out.println("완료");
                System.out.println(dictString);
                System.out.println(poll.getCnt());

                if (max < poll.getCnt())
                    max = poll.getCnt();
                continue;
            }
            for (int i = 0; i < word_dict.length; i++) {
                if (word_dict[i].charAt(0) == dictString.charAt(dictString.length()-1)) {
                    if (dictString.length()-1+word_dict[i].length() > s.length()) {
                        continue;
                    }
                    String substring = s.substring(dictString.length()-1, dictString.length()-1+word_dict[i].length());
                    if (substring.equals(word_dict[i])) {
                        String concat = dictString.concat(word_dict[i].substring(1));
                        System.out.println(dictString);
                        System.out.println(concat);
                        System.out.println(poll.getCnt()+1);
                        q.add(new CheckSum(concat, poll.getCnt()+1));
                    }
                }
            }
        }

        return max;
    }
}
class CheckSum {
    String dictString;
    int cnt;

    public CheckSum(String dictString, int cnt) {
        this.dictString = dictString;
        this.cnt = cnt;
    }
    public String getDictString() {
        return dictString;
    }
    public int getCnt() {
        return cnt;
    }
}