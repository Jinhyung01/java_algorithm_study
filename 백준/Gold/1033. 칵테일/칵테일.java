import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static long[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        result = new long[N];
        long lcm = 1;
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            addEdge(a, b, p, q);
            lcm *= lcm(p, q);
        }
        dfs(0, lcm);

        long gcd = 0;
        for (int i = 0; i < result.length; i++) {
            gcd = gcd(gcd, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]/gcd).append(" ");
        }
        System.out.print(sb);
    }

    private static void dfs(int cur, long lcm) {
        result[cur] = lcm;

        for (Node n : adj[cur]) {
            if (result[n.b]==0) {
                long r = lcm * n.q / n.p;
                dfs(n.b, r);
            }
        }
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static void addEdge(int a, int b, int p, int q) {
        adj[a].add(new Node(b, p, q));
        adj[b].add(new Node(a, q, p));
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