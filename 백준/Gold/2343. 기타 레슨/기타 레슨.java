import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] minutes = new int[N];
        st = new StringTokenizer(br.readLine());

        int low = 0;
        int high = 0;

        for (int i = 0; i < N; i++) {
            minutes[i] = Integer.parseInt(st.nextToken());
            high += minutes[i];
            if (low < minutes[i])
                low = minutes[i];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            int k = 1;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += minutes[i];
                if (mid < sum) {
                    k++;
                    sum = minutes[i];
                }
            }
            if (k > M) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(low);


    }
}