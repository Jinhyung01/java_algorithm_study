import java.io.*;
import java.util.*;


class Solution {
    static int[][] cost;
    static int N;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cost = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            min = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(1, 0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int depth, int sum) {
        if (sum >= min) return;
        if (depth == N + 1) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + cost[depth][i]);
                visited[i] = false;
            }
        }
    }
}
