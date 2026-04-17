import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] counts;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[v].add(u);
        }
        visited = new boolean[N + 1];
        counts = new int[N + 1];

        int maxVal = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited,false);
            counts[i] = bfs(i);
            maxVal = Math.max(maxVal, counts[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == maxVal) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : adj[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }

}