import java.io.*;
import java.util.*;


/*
루트 = 1
2 <= N <=10^5
 */
public class Main {
    static ArrayList<Integer>[] adj;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
        }
        dfs(1, -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int pre) {
        parent[cur] = pre;

        for (int next : adj[cur]) {
            if (parent[next] == 0) {
                dfs(next, cur);
            }
        }
    }

    private static void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
}