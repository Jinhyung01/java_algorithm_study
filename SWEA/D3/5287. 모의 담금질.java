import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double start = Double.parseDouble(st.nextToken());
            double end = Double.parseDouble(st.nextToken());
            double k = Double.parseDouble(st.nextToken());
            int count = 0;
            while (start > end) {
                count++;
                start *= k;
            }

            System.out.printf("#%d %d\n", t, count);
        }
    }
}
