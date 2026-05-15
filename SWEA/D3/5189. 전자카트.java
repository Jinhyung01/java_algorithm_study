import java.io.*;
import java.util.*;

class Solution {
    static int[] path;
    static int N, min;
    static int[][] e;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            e = new int[N + 1][N + 1];
            path = new int[N + 1];
            visited = new boolean[N + 1];
            min = Integer.MAX_VALUE;


            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    e[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            path[0] = path[N] = 1;

            dfs(1);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.print(sb);

    }

    private static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += e[path[i]][path[i + 1]];
            }
            min = Math.min(min, sum);
            return;
        }
        for (int i = 2; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
