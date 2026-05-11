import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Integer[] cont = new Integer[N];
            Integer[] truck = new Integer[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cont[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                truck[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(cont, Collections.reverseOrder());
            Arrays.sort(truck, Collections.reverseOrder());
            int result = 0;
            int j = 0;
            for (int i = 0; i < M; i++) {
                while (j < N && truck[i] < cont[j]) {
                    j++;
                }
                if (j >= N) break;
                result += cont[j];
                j++;
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
