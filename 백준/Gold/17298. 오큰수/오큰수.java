import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] answer = new int[N];

        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peekLast()] < A[i]) {
                answer[stack.pollLast()] = A[i];
            }
            stack.offerLast(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pollLast()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}