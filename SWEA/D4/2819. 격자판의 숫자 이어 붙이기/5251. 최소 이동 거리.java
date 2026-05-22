import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<Node>[] adj;
    static int[] dis;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            adj = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adj[s].add(new Node(e, w));
            }
            dis = new int[N + 1];
            Arrays.fill(dis, INF);
            PriorityQueue<Node> pq = new PriorityQueue<>();
            dis[0] = 0;
            pq.offer(new Node(0, 0));

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                if (node.index == N) break;
                if (node.distance > dis[node.index]) continue;
                for (Node neighbor : adj[node.index]) {
                    int cost = node.distance + neighbor.distance;
                    if (dis[neighbor.index] > cost) {
                        dis[neighbor.index] = cost;
                        pq.offer(new Node(neighbor.index, cost));
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(dis[N]).append("\n");
        }
        System.out.println(sb);
    }

    public static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
