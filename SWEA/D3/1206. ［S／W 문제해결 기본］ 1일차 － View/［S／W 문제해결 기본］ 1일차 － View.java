import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] building = new int[N];
            for (int j = 0; j < N; j++) {
                building[j] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            for (int j = 2; j < N - 2; j++) {
                int cur = building[j];

                int maxSideH = 0;
                maxSideH = Math.max(building[j - 2], building[j - 1]);
                maxSideH = Math.max(maxSideH, building[j + 1]);
                maxSideH = Math.max(maxSideH, building[j + 2]);

                if (cur > maxSideH) {
                    result += (cur - maxSideH);
                }
            }
            sb.append("#").append(i).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}