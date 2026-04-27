import java.io.*;
import java.util.*;

public class Main {
    static int N, start, end, M;
    static long[] dis;
    static final long INF = Long.MIN_VALUE;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        dis = new long[N];
        int[] getMoney = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            getMoney[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dis, INF);
        dis[start] = getMoney[start];

        boolean isGee = false;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (dis[edge.u] != INF) {
                    if (dis[edge.v] < dis[edge.u] - edge.w + getMoney[edge.v]) {
                        dis[edge.v] = dis[edge.u] - edge.w + getMoney[edge.v];
                        if (i == N - 1) {
                            if (bfs(edge.v)) {
                                isGee = true;
                            }
                        }
                    }
                }
            }
            if(isGee) break;
        }


        if (isGee) {
            System.out.println("Gee");
        } else {
            System.out.println(dis[end] == INF ? "gg" : dis[end]);
        }

    }

    private static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == end) return true;

            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                int from = edge.u;
                int to = edge.v;
                if (from == now && !visited[to]) {
                    visited[to] = true;
                    q.offer(to);
                }
            }
        }
        return false;
    }

    public static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}