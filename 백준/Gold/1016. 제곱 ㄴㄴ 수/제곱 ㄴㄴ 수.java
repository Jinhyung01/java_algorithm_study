import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] visited = new boolean[(int) (max - min + 1)];
        int cnt = 0;

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;

            long start = min / square;
            if (min % square != 0) {
                start++;
            }

            for (long j = start; j * square <= max; j++) {
                visited[(int) (j * square - min)] = true;
            }
        }
        for (boolean i : visited) {
            if(!i)
                cnt++;
        }
        System.out.println(cnt);

    }
}