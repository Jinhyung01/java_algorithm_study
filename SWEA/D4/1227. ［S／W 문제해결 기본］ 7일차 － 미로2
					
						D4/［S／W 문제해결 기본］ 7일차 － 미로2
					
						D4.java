import java.io.*;
import java.util.*;

public class Solution {
    static int[] start;
    static int[] end = new int[2];
    static int[][] maze = new int[100][100];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    int n = str.charAt(j) - '0';
                    maze[i][j] = n;
                    if (n == 2) {
                        start = new int[]{i, j};
                    } else if (n == 3) {
                        end = new int[]{i, j};
                    }
                }
            }
            isPossible = 0;
            visited = new boolean[100][100];
            dfs(start[0], start[1]);
            sb.append("#").append(tc).append(" ").append(isPossible).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            if (isPossible == 1) return;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                if (maze[nx][ny] != 1 && !visited[nx][ny]) {
                    if (nx == end[0] && ny == end[1]) {
                        isPossible = 1;
                        return;
                    }
                    dfs(nx, ny);
                }
            }
        }
    }
}