import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        visited = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long temp = i * i;
            long start = min / temp;
            if (min % temp != 0) {
                start++;
            }
            for (long j = start * temp; j <= max; j += temp) {
                if (!visited[(int) (j - min)] ) {
                    visited[(int)(j - min)] = true;
                }
            }
        }
        long cnt = 0;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}