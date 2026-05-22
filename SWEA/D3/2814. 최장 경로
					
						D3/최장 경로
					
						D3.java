import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adj[x].add(y);
                adj[y].add(x);
            }
            max = 0;
            for (int v = 1; v <= N; v++) {
                dfs(v, 1);
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int cur, int count) {
        visited[cur] = true;
        if (count > max) max = count;

        for (int next : adj[cur]) {
            if (!visited[next]) {
                dfs(next, count + 1);
            }
        }
        visited[cur] = false;
    }
}