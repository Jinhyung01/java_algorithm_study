import java.io.*;
import java.util.*;

public class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] A = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    A[i][j] = str.charAt(j) - '0';
                }
            }
            int result = 0;
            int iter = (N - 1) / 2;
            Queue<int[]> q = new LinkedList<>();
            visited[iter][iter] = true;
            q.offer(new int[]{iter, iter, 0});
            result += A[iter][iter];
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                if (poll[2] == iter) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        result += A[nx][ny];
                        q.offer(new int[]{nx, ny, poll[2] + 1});
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
