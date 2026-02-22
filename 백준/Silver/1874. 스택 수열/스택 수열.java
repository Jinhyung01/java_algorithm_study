import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;

        boolean possible = true;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (cnt <= num) {
                stack.offerLast(cnt);
                sb.append("+\n");
                cnt++;
            }
            if (!stack.isEmpty() && stack.peekLast() == num) {
                stack.pollLast();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? sb : "NO");
    }
}