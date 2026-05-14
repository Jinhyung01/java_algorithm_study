import java.io.*;
import java.util.*;

class Main {
    // dp[i][w] : 물건 i개를 고려했을 때, 무게 한도 w에서 담을 수 있는 최대 가치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            weight[i] = W;
            value[i] = V;
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (weight[i] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], value[i] + dp[i - 1][w - weight[i]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
