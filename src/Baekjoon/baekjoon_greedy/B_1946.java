package Baekjoon.baekjoon_greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B_1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int i = 0; i < testCase; i++) {
			CalculatePass calculatePass = new CalculatePass();

			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				int doc = sc.nextInt();
				int interview = sc.nextInt();
				calculatePass.addPerson(new Person(doc, interview));
			}

			int result = calculatePass.calculate();

			System.out.println(result);
		}
	}
}

class CalculatePass {
	private final List<Person> people = new ArrayList<>();

	public void addPerson(Person person) {
		people.add(person);
	}

	public int calculate() {
		people.sort(Comparator.comparingInt(Person::getDoc));
		int min = people.get(0).getInterview();
		int cnt = 1;

		for (int k = 1; k < people.size(); k++) {
			Person person = people.get(k);
			if (person.checkPass(min)) {
				cnt++;
				min = person.getInterview();
			}
		}

		return cnt;
	}
}

class Person {
	private final int doc;
	private final int interview;

	public Person(int doc, int interview) {
		this.doc = doc;
		this.interview = interview;
	}

	public int getDoc() {
		return doc;
	}

	public int getInterview() {
		return interview;
	}

	public boolean checkPass(int min) {
		return min > interview;
	}
}
