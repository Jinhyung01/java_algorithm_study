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


        dfs(0, 0, limit[2]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int A, int B, int C) {
        visited[A][B] = true;

        if (A == 0) {
            result[C] = true;
        }



        for (int i = 0; i < 6; i++) {
            int[] current = {A, B, C};
            int from = fromIdx[i];
            int to = toIdx[i];


            current[to] = current[to] + current[from];
            current[from] = 0;
            if (current[to] > limit[to]) {
                current[from] = current[to] - limit[to];
                current[to] = limit[to];
            }


            if (!visited[current[0]][current[1]]) {
                dfs(current[0], current[1], current[2]);
            }
        }

    }
}