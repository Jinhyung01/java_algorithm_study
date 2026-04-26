import java.util.*;
import java.io.*;

public class Main {
    static int[] maxTime;
    static ArrayList<Node>[] adj;
    static ArrayList<Node>[] reverseAdj;
    static int[] inDegree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        inDegree = new int[n + 1];
        maxTime = new int[n + 1];
        adj = new ArrayList[n + 1];
        reverseAdj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
            inDegree[v]++;
            reverseAdj[v].add(new Node(u, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();

            for (Node next : adj[now]) {
                inDegree[next.v]--;
                maxTime[next.v] = Math.max(maxTime[next.v], maxTime[now] + next.distance);
                if (inDegree[next.v] == 0) {
                    q.offer(next.v);
                }
            }
        }
        System.out.println(maxTime[end]);
        bfs(end);

    }

    private static void bfs(int start) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (Node pre : reverseAdj[now]) {
                if (maxTime[now] - pre.distance == maxTime[pre.v]) {
                    cnt++;
                    if (!visited[pre.v]) {
                        visited[pre.v] = true;
                        q.offer(pre.v);
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    public static class Node {
        int v;
        int distance;

        public Node(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }
    }
}