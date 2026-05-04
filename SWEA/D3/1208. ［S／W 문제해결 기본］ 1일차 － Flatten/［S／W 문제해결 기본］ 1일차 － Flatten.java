import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int dumbCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[100];
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            for (int d = 1; d <= dumbCount; d++) {
                A[0]++;
                A[99]--;
                Arrays.sort(A);
                if (A[99] - A[0] <= 1) {
                    break;
                }
            }
            sb.append("#").append(t).append(" ").append(A[99] - A[0]).append("\n");
        }
        System.out.println(sb);
    }
}