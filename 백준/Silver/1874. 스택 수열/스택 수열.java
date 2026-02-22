import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num - cnt > 0) {
                for (int k = cnt + 1; k <= num; k++) {
                    stack.offerLast(k);
                    cnt++;
                    sb.append("+\n");
                }
                stack.pollLast();
                sb.append("-\n");
            } else {
                if (stack.peekLast() != num) {
                    System.out.println("NO");
                    return;
                }
                stack.pollLast();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}