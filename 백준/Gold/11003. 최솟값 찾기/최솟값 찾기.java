import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (!deque.isEmpty() && deque.peekFirst().index <= i - L)
                deque.pollFirst();

            while (!deque.isEmpty() && deque.peekLast().value > n) {
                deque.pollLast();
            }

            deque.offerLast(new Node(i, n));
            sb.append(deque.peekFirst().value).append(" ");
        }
        System.out.println(sb);

    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}