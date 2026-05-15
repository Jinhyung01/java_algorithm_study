import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 재료수
            int L = Integer.parseInt(st.nextToken()); // 제한칼로리
            int[] score = new int[N + 1];
            int[] cal = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[L + 1];

            for (int i = 1; i <= N; i++) {
                for (int w = L; w >= cal[i]; w--) {
                    dp[w] = Math.max(dp[w], dp[w - cal[i]] + score[i]);
                }
            }
            sb.append("#").append(t).append(" ").append(dp[L]).append("\n");
        }
        System.out.println(sb);
    }
}
