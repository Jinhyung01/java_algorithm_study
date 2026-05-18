import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            for (int i = 0; i < M; i++) {
                if (binarySearch(A, B[i]))
                    result++;
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }

    private static boolean binarySearch(int[] A, int num) {
        int low = 0;
        int high = A.length - 1;
        boolean isRight = false;
        boolean isLeft = false;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < num) {
                if (isRight) return false;
                low = mid + 1;
                isRight = true;
                isLeft = false;
            } else if (A[mid] > num) {
                if (isLeft) return false;
                high = mid - 1;
                isLeft = true;
                isRight = false;
            } else {
                return true;
            }
        }
        return false;
    }
}
