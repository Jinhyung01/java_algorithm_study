import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];
            int c = 0;
            int r = 0;
            int dir = 0;
            for (int num = 1; num <= N * N; num++) {
                snail[c][r] = num;
                int nx = c + dx[dir];
                int ny = r + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || snail[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = c + dx[dir];
                    ny = r + dy[dir];
                }
                c = nx;
                r = ny;
            }
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
