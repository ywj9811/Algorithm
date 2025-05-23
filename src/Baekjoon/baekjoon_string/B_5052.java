package Baekjoon.baekjoon_string;

import java.util.*;

public class B_5052 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0 ; i < t; i++) {
            int size = sc.nextInt();
            checkPrefix(size);
        }
    }

    private static void checkPrefix(int size) {
        TrieNode node = new TrieNode();
        Trie trie = new Trie();

        List<String> numbers = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            numbers.add(sc.next());
        }

        boolean isConsistent = true;

        for (String number : numbers) {
            if (!trie.insert(node, number)) {
                isConsistent = false; //만약 접두사가 발견되면 false 처리 후 반복 중단
                break;
            }
        }

        System.out.println(isConsistent ? "YES" : "NO");
    }

    private static class Trie {

        // insert하면서 접두어 충돌 검사
        boolean insert(TrieNode node, String number) {
            for (char ch : number.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
                if (node.isEndOfWord)
                    return false; // 여기까지가 끝인 번호가 있음 -> 더 나아가면 해당 번호는 다른 번호를 포함하게 됨
            }
            if (!node.children.isEmpty())
                return false; // 만약 끝까지 진행했는데, 아래에 트리가 더 남아있다면 해당 번호가 다른 번호에 포함되게 됨.
            node.isEndOfWord = true; // 끝까지 진행했기 때문에 여기서 끝난 숫자가 존재함을 표시
            return true;
        }
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }
}