import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static PriorityQueue<Integer>[] dis;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dis = new PriorityQueue[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = new PriorityQueue<>(Collections.reverseOrder());
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
        }
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dis[i].size() < k) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dis[i].poll()).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[1].offer(0);
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : adj[now.v]) {
                int cost = now.dis + next.dis;
                if (dis[next.v].size() < k) {
                    dis[next.v].offer(cost);
                    pq.offer(new Node(next.v, cost));
                } else if (dis[next.v].peek() > cost) {
                    dis[next.v].poll();
                    dis[next.v].offer(cost);
                    pq.offer(new Node(next.v, cost));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int v, dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dis, o.dis);
        }
    }
}