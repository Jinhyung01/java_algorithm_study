import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int cnt = 0;
        int i = 0, j = N - 1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < M)
                i++;
            else if (sum > M)
                j--;
            else {
                cnt++;
                i++;
                j--;
            }
        }
        System.out.println(cnt);
    }
}