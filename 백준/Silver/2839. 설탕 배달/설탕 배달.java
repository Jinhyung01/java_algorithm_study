import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = Integer.MAX_VALUE;
        for (int x = 0; x <= N / 5; x++) {
            for (int y = 0; y <= N / 3; y++) {
                int sum = 5 * x + 3 * y;
                if (sum == N) {
                    cnt = Math.min(cnt, x + y);
                }
            }
        }
        System.out.print(cnt == Integer.MAX_VALUE ? -1 : cnt);

    }
}