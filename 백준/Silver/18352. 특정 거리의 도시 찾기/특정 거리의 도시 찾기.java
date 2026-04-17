import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        dis = new int[N + 1];
        Arrays.fill(dis, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        bfs(X);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == K) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.length()==0 ? -1 : sb);
    }
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        dis[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                if (dis[next] == -1) {
                    dis[next] = dis[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }

}