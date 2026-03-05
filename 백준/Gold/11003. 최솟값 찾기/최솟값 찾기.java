import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            while (!dq.isEmpty() && A[dq.peekLast()] >=A[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (dq.peekFirst() <= i - L) {
                dq.pollFirst();
            }
            sb.append(A[dq.peekFirst()]).append(" ");
        }
        System.out.println(sb);

    }
}