import java.io.*;
import java.util.*;


public class Main {
    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] D = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(D[i], INF);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) D[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (D[a][b] > c) D[a][b] = c;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (D[i][j] == INF) sb.append(0).append(" ");
                else sb.append(D[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}