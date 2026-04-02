import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    static int cnt = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            isGoodNumber(i);
        }
        System.out.println(cnt);
    }

    private static void isGoodNumber(int index) {
        int i = 0, j = N - 1;
        while (i < j) {
            if (index == i) {
                i++;
                continue;
            }
            if (index == j) {
                j--;
                continue;
            }
            int sum = A[i] + A[j];
            if (sum < A[index]) {
                i++;
            } else if (sum > A[index]) {
                j--;
            } else {
                cnt++;
                break;
            }
        }

    }
}