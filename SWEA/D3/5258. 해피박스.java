import java.io.*;
import java.util.*;


class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] sizes = new int[M + 1];
            int[] prices = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int size = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                sizes[i] = size;
                prices[i] = price;
            }
            int[][] dp = new int[M + 1][N + 1];
            for (int i = 1; i <= M; i++) {
                for (int w = 1; w <= N; w++) {
                    if (w >= sizes[i]) {
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - sizes[i]] + prices[i]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(dp[M][N]).append("\n");
        }
        System.out.print(sb);
    }
}
