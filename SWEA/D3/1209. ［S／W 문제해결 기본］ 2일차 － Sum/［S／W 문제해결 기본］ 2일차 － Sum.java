import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] A = new int[100][100];

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int maxSum = 0;
            int lDiagSum = 0;
            int rDiagSum = 0;

            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int curSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += A[i][j];
                    curSum += A[j][i];
                    if (i == j) {
                        rDiagSum += A[i][j];
                    }
                    if (i + j == 4) {
                        lDiagSum += A[i][j];
                    }
                }
                maxSum = Math.max(Math.max(maxSum, rowSum), curSum);
            }
            maxSum = Math.max(Math.max(maxSum, lDiagSum), rDiagSum);
            sb.append("#").append(t).append(" ").append(maxSum).append("\n");
        }
        System.out.println(sb);
    }
}