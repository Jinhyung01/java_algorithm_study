import java.io.*;
import java.util.*;

import static java.util.Collections.binarySearch;
import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<Integer> A = new ArrayList<>();
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }
            sort(A);
            int result = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
                if (binarySearch(A, B[i]) >= 0) {
                    result++;
                }
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }
}
