import java.io.*;
import java.util.*;

public class Solution {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] station = new int[N + 1];
            for (int i = 1; i < N; i++) {
                station[i] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            boolean[] visited = new boolean[N + 1];
            Queue<int[]> q = new LinkedList<>();
            // {현재 정류장, 교환횟수}
            q.offer(new int[]{1, 0});
            visited[1] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int curStation = cur[0];
                int swapCount = cur[1];
                if (curStation == N) {
                    result = swapCount;
                    break;
                }
                for (int i = curStation + 1; i <= curStation + station[curStation]; i++) {
                    if (i <= N && !visited[i]) {
                        visited[i] = true;
                        q.offer(new int[]{i, swapCount + 1});
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(result - 1).append("\n");
        }
        System.out.print(sb);
    }
}
