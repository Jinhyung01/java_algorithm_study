import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dis = new int[N + 1][M + 1];
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = arr[j-1] - '0';
                dis[i][j] = -1;
            }
        }
        bfs(1, 1);
        System.out.println(dis[N][M]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        dis[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            int curX = curPoint[0];
            int curY = curPoint[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (map[nx][ny] == 1 && dis[nx][ny] == -1) {
                        dis[nx][ny] = dis[curX][curY] + 1;
                        if (nx == N && ny == M) return;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}