import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 1; i <= N; i++) {
            int num = bfs(i);
            if (min > num) {
                min = num;
                idx = i;
            }
        }
        System.out.println(idx);
    }

    private static int bfs(int start) {
        int[] dis = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dis[start] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : adj[now]) {
                if (dis[next] == 0) {
                    dis[next] = dis[now] + 1;
                    q.offer(next);
                }
            }
        }


        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dis[i];
        }
        return sum;
    }
}