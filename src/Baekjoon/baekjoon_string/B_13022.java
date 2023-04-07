package Baekjoon.baekjoon_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_13022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputWord = br.readLine();

        int w = 0;
        int o = 0;
        int l = 0;
        int f = 0;

        int value = 1;

        for (int i = 0; i < inputWord.length(); i++) {
            char charAt = inputWord.charAt(i);
            if (charAt == 'w') {
                if (i != 0) {
                    if (inputWord.charAt(i - 1) != 'f' && inputWord.charAt(i - 1) != 'w') {
                        value = 0;
                        break;
                    }
                    if (inputWord.charAt(i - 1) == 'f') {
                        if (!(w == o && o == l && l == f)) {
                            value = 0;
                            break;
                        }
                    }
                }
                w++;
                continue;
            } else if (charAt == 'o') {
                if (i == 0 || !(inputWord.charAt(i - 1) == 'w' || inputWord.charAt(i - 1) == 'o')) {
                    value = 0;
                    break;
                }
                o++;
                continue;
            } else if (charAt == 'l') {
                if (i == 0 || !(inputWord.charAt(i - 1) == 'o' || inputWord.charAt(i - 1) == 'l')) {
                    value = 0;
                    break;
                }
                l++;
                continue;
            } else if (charAt == 'f') {
                if (i == 0 || !(inputWord.charAt(i - 1) == 'l' || inputWord.charAt(i - 1) == 'f')) {
                    value = 0;
                    break;
                }
                f++;
                continue;
            } else {
                value = 0;
                break;
            }
        }
        if (!(w == o && o == l && l == f))
            value = 0;

        System.out.println(value);
    }
}
/**
 * 순서는 w o l f 가 되어야 함
 * 모두 n번씩 사용되어야 함
 * w ~ f 한 텀이 끝나면 다시 올바른 단어로 이어갈 수 있다.
 */