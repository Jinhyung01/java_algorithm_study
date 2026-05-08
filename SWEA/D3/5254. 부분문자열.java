import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            PriorityQueue<String> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            TreeSet<String> subStrings = new TreeSet<>();
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j <= str.length(); j++) {
                    subStrings.add(str.substring(i, j));
                }
            }
            String result = "";
            int n = 0;
            for (String s : subStrings) {
                if (++n == N) {
                    result = s;
                    break;
                }
            }
            sb.append("#").append(t).append(" ").append(result.charAt(0)).append(" ").append(result.length()).append("\n");
        }
        System.out.print(sb);

    }
}
