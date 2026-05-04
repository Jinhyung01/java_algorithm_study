import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int l = Integer.parseInt(br.readLine());
            int[][] A = new int[l][l];
            int cnt = 0;
            for (int i = 0; i < l; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < l; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < l; j++) {
                boolean isOneExist = true;
                for (int i = 0; i < l; i++) {
                    if (isOneExist) {
                        if (A[i][j] == 1) {
                            isOneExist = false;
                        }
                    } else {
                        if (A[i][j] == 2) {
                            cnt++;
                            isOneExist = true;
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}