import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] station = new int[N + 1];
            for (int i = 1; i < N; i++) {
                station[i] = Integer.parseInt(st.nextToken());
            }

            int max = 1;
            int result = 0;
            int curIdx = 1;
            while (true) {
                int start = curIdx + 1;
                int end = curIdx + station[curIdx];
                if (end >= N)
                    break;
                for (int i = start; i <= end; i++) {
                    if (max < i + station[i]) {
                        max = i + station[i];
                        curIdx = i;
                    }
                }
                result++;
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}
