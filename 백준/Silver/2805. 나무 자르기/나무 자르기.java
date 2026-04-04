import java.io.*;
import java.util.*;


public class Main {
    static int[] trees;
    static int maxHeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > maxHeight) {
                maxHeight = trees[i];
            }
        }

        long result;
        int low = 0;
        int high = maxHeight;
        while (low < high) {
            result = 0;
            int mid = low + (high - low) / 2;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    result += (trees[i] - mid);
                }
            }
            if (result < M) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low-1);

    }
}