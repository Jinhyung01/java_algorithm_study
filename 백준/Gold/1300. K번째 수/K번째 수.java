import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int low = 1;
        int high = k;

        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N,mid / i);
            }
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(low);

    }
}