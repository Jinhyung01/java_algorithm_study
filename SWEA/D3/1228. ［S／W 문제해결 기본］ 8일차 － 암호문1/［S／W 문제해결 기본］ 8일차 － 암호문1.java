import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> pw = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pw.add(Integer.parseInt(st.nextToken()));
            }
            int cCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < cCount; i++) {
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int[] A = new int[y];
                for (int j = 0; j < y; j++) {
                    A[j] = Integer.parseInt(st.nextToken());
                }
                for (int j = y - 1; j >= 0; j--) {
                    pw.add(x, A[j]);
                }
            }
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(pw.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}