import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] station = new int[N + 1];
            for (int i = 1; i < N; i++) {
                station[i] = Integer.parseInt(st.nextToken());
            }
            // i번 정류장에 도달하는 최소 교환 횟수
            int[] dp = new int[N + 1];
            Arrays.fill(dp, INF);
            dp[1] = 0;
            // i번째 정류장에서 j번만큼 간 정류장
            for (int i = 1; i < N; i++) {
                for (int j = 1; j <= station[i]; j++) {
                    int next = i + j;
                    if (next <= N) {
                        dp[next] = Math.min(dp[next], dp[i] + 1);
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(dp[N] - 1).append("\n");
        }
        System.out.print(sb);
    }
}
