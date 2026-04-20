import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited = new boolean[201][201];
    static boolean[] result = new boolean[201];
    static int[] limit = new int[3];
    static int[] fromIdx = {0, 0, 1, 1, 2, 2};
    static int[] toIdx = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit[0] = Integer.parseInt(st.nextToken());
        limit[1] = Integer.parseInt(st.nextToken());
        limit[2] = Integer.parseInt(st.nextToken());


        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0, limit[2]});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int A = cur[0];
            int B = cur[1];
            int C = cur[2];

            if (A == 0) {
                result[C] = true;
            }

            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};

                int from = fromIdx[i];
                int to = toIdx[i];

                next[to] += next[from];
                next[from] = 0;
                if (next[to] > limit[to]) {
                    next[from] = next[to] - limit[to];
                    next[to] = limit[to];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] =true;
                    queue.offer(next);
                }
            }
        }
    }
}