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

            ArrayList<Integer> result = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                result.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i < M; i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    tmp.add(Integer.parseInt(st.nextToken()));
                }
                boolean complete = false;
                for (int j = 0; j < result.size(); j++) {
                    if (tmp.get(0) < result.get(j)) {
                        result.addAll(j, tmp);
                        complete = true;
                        break;
                    }
                }
                if (!complete) {
                    result.addAll(tmp);
                }
            }
            sb.append("#").append(t).append(" ");
            int n = result.size() - 1;
            for (int i = n; i > n - 10; i--) {
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
