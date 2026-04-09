import java.io.*;
import java.util.*;


public class Main {
    static int[] dis;
    static ArrayList<Node>[] adj;
    static int endNode;
    static int max = 0;


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
                int dis = Integer.parseInt(st.nextToken());
                adj[u].add(new Node(v, dis));
            }

        }
        bfs(1);

        Arrays.fill(dis, -1);
        bfs(endNode);
        System.out.print(max);

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        dis[start] = 0;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            if (max < dis[curNode]) {
                max = dis[curNode];
                endNode = curNode;
            }

            for (Node next : adj[curNode]) {
                if (dis[next.v] == -1) {
                    dis[next.v] = dis[curNode] + next.dis;
                    queue.offer(next.v);
                }
            }
        }
    }

    static class Node {
        int v;
        int dis;

        public Node(int v, int dis) {
            this.dis = dis;
            this.v = v;
        }
    }
}