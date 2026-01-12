import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            max = Math.max(max, score);
            sum += score;
        }
        double result = (double) (sum) / max * 100 / n;
        System.out.print(result);

    }
}


