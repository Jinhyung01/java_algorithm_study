import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int size = (int) (max - min + 1);
        boolean[] visited = new boolean[size];

        for (long i = 2; i * i <= max; i++) {
            long temp = i * i;
            long start = min / temp;

            if (min % temp != 0) {
                start++;
            }

            for (long j = start; j * temp <= max; j++) {
                int idx = (int) (j * temp - min);
                if (!visited[idx])
                    visited[idx] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}