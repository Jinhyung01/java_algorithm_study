import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean isExist = false;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
        }
        for (int i = 0; i < N; i++) {
            dfs(1, i);
            if (isExist) break;
        }
        System.out.println(isExist ? 1 : 0);

    }

    private static void dfs(int depth, int cur) {
        if (depth == 5) {
            isExist = true;
            return;
        }
        visited[cur] = true;
        for (int next : adj[cur]) {
            if (!visited[next]) {
                dfs(depth + 1, next);
                if (isExist) break;
            }
        }
        visited[cur] = false;
    }

    private static void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
}