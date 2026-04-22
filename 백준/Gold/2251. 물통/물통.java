import java.io.*;
import java.util.*;

public class Main {
    static int[] limit = new int[3];
    static boolean[][] visited = new boolean[201][201];
    static boolean[] result = new boolean[201];
    static int[] fromIdx = {0, 0, 1, 1, 2, 2};
    static int[] toIdx = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit[0] = Integer.parseInt(st.nextToken());
        limit[1] = Integer.parseInt(st.nextToken());
        limit[2] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= limit[2]; i++) {
            if (result[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int A, int B) {
        visited[A][B] = true;

        if (A == 0) {
            result[limit[2] - B] = true;
        }

        for (int i = 0; i < 6; i++) {
            int[] next = {A, B, limit[2] - A - B};
            int nFrom = fromIdx[i];
            int nTo = toIdx[i];

            next[nTo] += next[nFrom];
            next[nFrom] = 0;

            if (next[nTo] > limit[nTo]) {
                next[nFrom] =next[nTo]- limit[nTo];
                next[nTo] = limit[nTo];
            }

            if (!visited[next[0]][next[1]]) {
                dfs(next[0], next[1]);
            }
        }
    }
}