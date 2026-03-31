import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] C = new long[M];
        long[] S = new long[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }
        long result = 0;
        for (int i = 1; i <= N; i++) {
            int remainder = (int) (S[i] % M);
            if (remainder == 0) result++;
            C[remainder]++;
        }
        for (int i = 0; i < C.length; i++) {
            if (C[i] > 1) {
                result = result + (C[i] * (C[i] - 1)) / 2;
            }
        }
        System.out.println(result);

    }
}