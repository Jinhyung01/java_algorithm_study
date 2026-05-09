import java.util.*;
import java.io.*;

class Solution {
    static int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static int N, K;
    static int sum;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            sum = 0;
            result = 0;

            dfs(0, 0);
            sb.append("#").append(t).append(" ").append(result).append("\n");

        }
        System.out.print(sb);
    }

    private static void dfs(int start, int depth) {
        if (depth == N) {
            if (sum == K) {
                result++;
            }
            return;
        }
        for (int i = start; i < A.length; i++) {
            sum += A[i];
            dfs(i + 1, depth + 1);
            sum -= A[i];
        }
    }
}
