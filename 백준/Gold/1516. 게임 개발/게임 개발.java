import java.util.*;
import java.io.*;

public class Main {
    static int[] inDegree;
    static ArrayList<Integer>[] adj;
    static int[] result;
    static int[] selfBuildTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        result = new int[N + 1];
        inDegree = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        selfBuildTime = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuildTime[i] = Integer.parseInt(st.nextToken());
            int preBuild;
            while ((preBuild = Integer.parseInt(st.nextToken())) != -1) {
                adj[preBuild].add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                result[i] = selfBuildTime[i];
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : adj[now]) {
                result[next] = Math.max(result[next], selfBuildTime[next] + result[now]);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

}