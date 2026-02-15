import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] S = new long[N + 1];
        long[] C = new long[M];

        long result = 0;
        for (int i = 1; i < S.length; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < S.length; i++) {
            int remain = (int) (S[i] % M);
            if (remain == 0) result++;
            C[remain]++;
        }
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                result = result + (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(result);
    }
}