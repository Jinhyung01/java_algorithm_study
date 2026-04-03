import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V);

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i : adj[n]) {
                if (!visited[i]) {
                    visited[i] = true;
                    sb.append(i).append(" ");
                    queue.offer(i);
                }
            }
        }
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");

        for (int next : adj[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
}