import java.io.*;
import java.util.*;

class Main {
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

        int[] dp = new int[K + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = K; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], value[i] + dp[w - weight[i]]);
            }
        }
        System.out.println(dp[K]);

    }

}
