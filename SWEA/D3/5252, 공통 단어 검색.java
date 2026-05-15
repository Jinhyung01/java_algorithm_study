import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            HashSet<String> str = new HashSet<>();
            for (int i = 0; i < N; i++) {
                str.add(br.readLine());
            }
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (str.contains(br.readLine())) {
                    cnt++;
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
