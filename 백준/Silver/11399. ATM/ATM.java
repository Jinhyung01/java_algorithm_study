import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N + 1];
        int[] S = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int result = 0;
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + A[i];
            result = result + S[i];
        }

        System.out.println(result);
    }
}