import java.util.*;
import java.io.*;

class Solution {
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int curCount = getFlyCount(i, j);
                    if (curCount > max) {
                        max = curCount;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static int getFlyCount(int x, int y) {
        int sum = 0;

        for (int i = x; i < x + M; i++) {
            for (int j = y; j < y + M; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }
}