package Baekjoon.baekjoon_greedy;

import java.util.Scanner;

public class B_14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        Calculate calculate = new Calculate(new Coin());
        int result = calculate.calCoin(price);
        System.out.println(result);
    }
}

class Coin {
    private int five;
    private int second;

    public Coin() {
        this.five = 0;
        this.second = 0;
    }
    public int getFive() {
        return five;
    }

    public int getSecond() {
        return second;
    }
    public void updateFive(int five) {
        this.five = five;
    }

    public void updateSecond(int second) {
        this.second = second;
    }

    public int sum() {
        if (five + second == 0)
            return -1;
        return five + second;
    }
}

class Calculate {
    private Coin coin;

    public Calculate(Coin coin) {
        this.coin = coin;
    }

    public int calCoin(int price) {
        int remain = price % 5;

        if (remain%2 != 0) {
            if (price < 5) {
                return this.coin.sum();
            }
            coin.updateFive(price/5 - 1);
        } else {
            coin.updateFive(price / 5);
        }
        price -= 5*coin.getFive();
        coin.updateSecond(price/2);

        return this.coin.sum();
    }
}
