import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int min, N;
    static int[][] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            number = new int[N + 1][N + 1];
            min = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    number[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(1, 1, number[1][1]);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int sum) {
        if (x == N && y == N) {
            min = Math.min(sum, min);
            return;
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx <= N && ny <= N) {
                dfs(nx, ny, sum + number[nx][ny]);
            }
        }
    }

}
