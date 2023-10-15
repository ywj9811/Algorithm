package Baekjoon.ictIntern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test1 {
    public static void main(String[] args) {
        int[] books;
        int[] targets;
        int sum = 0;
        books = new int[]{3, 1, 2};
        targets = new int[]{1, 3, 2};

        LinkedList<Integer> currentBook = new LinkedList<>();
        for (int book : books) {
            currentBook.add(book);
        }

        for (int target : targets) {
            int index = currentBook.indexOf(target);
            currentBook.remove(index);
            currentBook.addFirst(target);
            sum += index;
//            ListIterator<Integer> iterator = currentBook.listIterator();
//            int index = 0;
//            while (iterator.hasNext()) {
//                if (iterator.next() == target) {
//                    iterator.remove();
//                    currentBook.addFirst(target);
//                    sum += index;
//                    break;
//                }
//                index++;
//            }
        }

        System.out.println(sum);
    }
}
