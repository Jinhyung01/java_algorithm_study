import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dis, map;
    static int[] start, end;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            dis = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dis[i], -1);
            }
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                    if (map[i][j] == 2) start = new int[]{i, j};
                    else if (map[i][j] == 3) end = new int[]{i, j};
                }
            }
            bfs(start[0], start[1]);
            int result = dis[end[0]][end[1]];

            sb.append("#").append(t).append(" ").append(result == -1 ? 0 : result - 1).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dis[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] != 1 && dis[nx][ny] == -1) {
                        dis[nx][ny] = dis[cur[0]][cur[1]] + 1;
                        if (nx == end[0] && ny == end[1]) {
                            return;
                        }
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}
