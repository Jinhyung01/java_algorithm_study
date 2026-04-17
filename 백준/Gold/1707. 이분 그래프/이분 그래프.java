import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];
            adj = new ArrayList[V + 1];
            for (int k = 1; k <= V; k++) {
                adj[k] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }
            boolean isBiGraph = true;
            for (int j = 1; j <= V; j++) {
                if (visited[j] == 0) {
                    if (!bfs(j)) {
                        isBiGraph = false;
                        break;
                    }
                }
            }
            System.out.println(isBiGraph ? "YES" : "NO");
        }

    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj[cur]) {
                if (visited[next] == 0) {
                    visited[next] = visited[cur] * -1;
                    queue.offer(next);
                } else if (visited[next] == visited[cur]) {
                    return false;
                }
            }
        }
        return true;

    }


}