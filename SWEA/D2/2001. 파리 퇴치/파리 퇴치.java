import java.util.*;
import java.io.*;

class Solution {
    static int[][] S;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            S = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 1; i <= N - M + 1; i++) {
                for (int j = 1; j <= N - M + 1; j++) {
                    int x2 = i + M - 1;
                    int y2 = j + M - 1;
                    int curCount = S[x2][y2] - S[i - 1][y2] - S[x2][j-1] + S[i - 1][j - 1];
                    if (curCount > max)
                        max = curCount;
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}