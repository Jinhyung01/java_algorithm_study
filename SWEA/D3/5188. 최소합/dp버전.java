import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] number = new int[N + 1][N + 1];
            int[][] dp = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    number[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 1; i <= N; i++) {
                dp[1][i] = dp[1][i - 1] + number[1][i];
                dp[i][1] = dp[i - 1][1] + number[i][1];
            }
            for (int i = 2; i <= N; i++) {
                for (int j = 2; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + number[i][j];
                }
            }
            sb.append("#").append(t).append(" ").append(dp[N][N]).append("\n");
        }
        System.out.print(sb);
    }
}
