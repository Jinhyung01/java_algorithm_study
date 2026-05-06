import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map = new int[4][4];
    static HashSet<String> numbers;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            numbers = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, 0, sb);
                }
            }
            System.out.println("#" + t + " " + numbers.size());
        }

    }

    private static void dfs(int x, int y, int depth, StringBuilder sb) {
        sb.append(map[x][y]);

        if (depth == 6) {
            numbers.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                dfs(nx, ny, depth + 1, sb);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }

}
