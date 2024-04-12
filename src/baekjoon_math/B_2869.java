package baekjoon_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int up = Integer.parseInt(s[0]);
		int down = Integer.parseInt(s[1]);
		int height = Integer.parseInt(s[2]);

		int totalDay = 1;

		height = height-up;

		int day = height / (up - down);
		totalDay += day;
		if (height%(up - down) != 0)
			totalDay++;
		System.out.println(totalDay);
	}
}