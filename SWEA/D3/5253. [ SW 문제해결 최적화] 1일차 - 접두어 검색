import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int cnt = 0;
            Trie root = new Trie();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            for (int i = 0; i < A; i++) {
                root.insert(br.readLine());
            }
            for (int i = 0; i < B; i++) {
                if (root.startsWith(br.readLine())) {
                    cnt++;
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfNode;
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.isEndOfNode = true;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    return false;
                }
                current = current.children.get(c);
            }
            return true;
        }
    }

}
