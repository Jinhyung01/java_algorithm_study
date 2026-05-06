import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Character> stack = new Stack<>();
            int N = Integer.parseInt(st.nextToken());
            String nums = st.nextToken();
            for (int i = 0; i < N; i++) {
                char c = nums.charAt(i);
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            sb.append("#").append(t).append(" ");

            for(Character c : stack) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}