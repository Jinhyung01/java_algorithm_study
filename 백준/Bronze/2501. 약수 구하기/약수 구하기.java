import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int size = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                arr[size] = i;
                size++;
            }
        }
        System.out.println(K>size ? 0 : arr[K-1]);
    }
}