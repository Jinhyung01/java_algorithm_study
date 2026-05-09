import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[] hasCharge = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                hasCharge[Integer.parseInt(st.nextToken())] = true;
            }

            int curPos = 0;
            int chPos = -1;
            int nextPos = curPos + K;
            int result = 0;

            while (nextPos < N) {
                for (int i = curPos; i <= nextPos; i++) {
                    if (hasCharge[i] && i != curPos) {
                        chPos = i;
                    }
                }
                if (chPos != -1) {
                    result++;
                } else {
                    result = 0;
                    break;
                }
                curPos = chPos;
                nextPos = curPos + K;
                chPos = -1;
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
