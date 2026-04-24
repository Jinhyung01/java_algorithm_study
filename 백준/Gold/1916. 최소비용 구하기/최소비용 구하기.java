import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] adj;
    static int[] dist;
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (dist[node.idx] < node.dis) continue;
            for (Node neighbor : adj[node.idx]) {
                int cost = dist[node.idx] + neighbor.dis;
                if (dist[neighbor.idx] > cost) {
                    dist[neighbor.idx] = cost;
                    pq.offer(new Node(neighbor.idx, cost));
                }
            }
        }
        System.out.println(dist[end]);
    }

    public static class Node implements Comparable<Node> {
        int idx;
        int dis;

        public Node(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.dis, o.dis);
        }
    }
}