import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (isGoodNumber(A, i))
                cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean isGoodNumber(int[] A, int n) {
        int i = 0;
        int j = A.length - 1;


        while (i < j) {
            if (i == n) {
                i++;
                continue;
            }
            if (j == n) {
                j--;
                continue;
            }
            int sum = A[i] + A[j];
            if (sum > A[n]) {
                j--;
            } else if (sum < A[n]) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
