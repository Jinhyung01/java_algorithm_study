import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 
            int L = Integer.parseInt(st.nextToken());
            List<Integer> nums = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                nums.add(idx, num);
            }

            sb.append("#").append(t).append(" ").append(nums.get(L)).append("\n");
        }
        System.out.print(sb);
    }
}
