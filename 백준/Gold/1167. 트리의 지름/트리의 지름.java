import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] adj;
    static int[] dis;
    static int endNode;
    static int maxDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        adj = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        dis = new int[V + 1];
        Arrays.fill(dis, -1);

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());

            int v;
            while ((v = Integer.parseInt(st.nextToken())) != -1) {
                int d = Integer.parseInt(st.nextToken());
                adj[u].add(new Node(v, d));
            }
        }

        bfs(1);
        Arrays.fill(dis, -1);
        maxDistance = 0;
        bfs(endNode);
        System.out.println(maxDistance);
    }


    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        dis[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (dis[now] > maxDistance) {
                maxDistance = dis[now];
                endNode = now;
            }

            for (Node n : adj[now]) {
                if (dis[n.v] == -1) {
                    dis[n.v] = dis[now] + n.dis;
                    queue.offer(n.v);
                }
            }
        }
    }

    public static class Node {
        int v;
        int dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }
}