import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Node>[] adj;
    static int[] dis;
    static int maxLength = 0;
    static int endNode = 0;

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

        bfs(endNode);
        System.out.println(maxLength);

    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        dis[start] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (maxLength < dis[cur.v]) {
                maxLength = dis[cur.v];
                endNode = cur.v;
            }

            for (Node next : adj[cur.v]) {
                if (dis[next.v] == -1) {
                    dis[next.v] = dis[cur.v] + next.dis;
                    queue.offer(next);
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