import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            Deque<Integer> dq = new ArrayDeque<>();
            int tNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            }
            int d = 1;
            while (dq.peekFirst() - d > 0) {
                dq.offerLast(dq.pollFirst() - d);
                d++;
                if (d > 5) {
                    d = 1;
                }
            }
            dq.pollFirst();
            dq.offerLast(0);


            sb.append("#").append(tNum).append(" ");
            while (!dq.isEmpty()) {
                sb.append(dq.pollFirst()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}