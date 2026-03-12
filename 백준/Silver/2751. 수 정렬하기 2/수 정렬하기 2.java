import java.io.*;

public class Main {
    static int K = 2000001;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[K];
        for (int i = 0; i < N; i++) {
            A[Integer.parseInt(br.readLine()) + 1000000]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            if (A[i]-- > 0) {
                sb.append(i - 1000000).append('\n');
            }
        }
        System.out.print(sb);
    }
}