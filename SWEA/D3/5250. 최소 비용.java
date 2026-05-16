import java.io.*;
import java.util.*;


class Solution {
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] H = new int[N][N];
            int[][] dis = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    H[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(dis[i], INF);
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            dis[0][0] = 0;
            pq.offer(new Node(0, 0, 0));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cur.x == N - 1 && cur.y == N - 1) break;
                if (dis[cur.x][cur.y] < cur.dis) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 & ny < N) {
                        int diff = H[cur.x][cur.y] - H[nx][ny] < 0 ? Math.abs(H[cur.x][cur.y] - H[nx][ny]) : 0;
                        int cost = dis[cur.x][cur.y] + diff + 1;
                        if (dis[nx][ny] > cost) {
                            dis[nx][ny] = cost;
                            pq.offer(new Node(nx, ny, cost));
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(dis[N - 1][N - 1]).append("\n");
        }
        System.out.print(sb);
    }

    public static class Node implements Comparable<Node> {
        int x, y;
        int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dis, o.dis);
        }
    }
}
