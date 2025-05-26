package Baekjoon.baekjoon_string;

import java.util.*;

public class B_14725 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        TrieNode root = new TrieNode(0);
        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            String[] values = new String[size];
            for (int j = 0; j < size; j++) {
                values[j] = sc.next();
            }
            Trie trie = new Trie();
            trie.insert(root, values);
        }

        root.printChildren();
    }

    private static class Trie {

        public void insert(TrieNode node, String[] values) {
            for (String value : values) {
                if (node.children.containsKey(value)) {
                    node = node.children.get(value);
                    continue;
                }
                node.children.put(value, new TrieNode(node.depth+1));
                node = node.children.get(value);
            }
        }
    }

    private static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        int depth;

        public TrieNode(int depth) {
            this.depth = depth;
        }

        public void printChildren() {
            List<String> sortedKeys = new ArrayList<>(children.keySet());
            Collections.sort(sortedKeys);

            for (String key : sortedKeys) {
                for (int i = 0; i < children.get(key).depth-1; i++) {
                    System.out.print("--");
                }
                System.out.println(key);

                children.get(key).printChildren();
            }
        }

    }
}
