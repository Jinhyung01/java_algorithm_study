import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] adj;
    static long[] mass;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        mass = new long[N];
        visited = new boolean[N];
        long lcm = 1;

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, p, q));
            adj[b].add(new Node(a, q, p));
            lcm *= (long) p * q / gcd(p, q);
        }
        mass[0] = lcm;
        dfs(0);
        long gcdVal = mass[0];
        for (int i = 1; i < N; i++) {
            gcdVal = gcd(gcdVal, mass[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(mass[i] / gcdVal).append(" ");
        }
        System.out.print(sb);
    }

    private static void dfs(int cur) {
        visited[cur] = true;

        for (Node n : adj[cur]) {
            if (!visited[n.b]) {
                mass[n.b] = mass[cur] * n.q / n.p;
                dfs(n.b);
            }
        }
    }

    private static long gcd(long p, long q) {
        while (q != 0) {
            long r = p % q;
            p = q;
            q = r;
        }
        return p;
    }

    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }
}