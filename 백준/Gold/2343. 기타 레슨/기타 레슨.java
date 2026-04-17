import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;
            sum += time;
            if (time > maxTime) {
                maxTime = time;
            }
        }

        int low = maxTime;
        int high = sum;

        Outer:
        while (low < high) {
            int mid = low + (high - low) / 2;
            int size = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                size += times[i];
                if (mid < size) {
                    count++;
                    size = times[i];
                    if (count > M) {
                        low = mid + 1;
                        continue Outer;
                    }
                }
            }
            high = mid;
        }

        System.out.println(high);

    }
}