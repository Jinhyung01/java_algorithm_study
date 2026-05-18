import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            double dividend = 1;
            double divisor = 1;
            int n = 9;
            for (int i = 1; i < N; i++) {
                dividend *= n;
                n--;
                divisor *= 10;
            }
            System.out.printf("#%d %.5f\n", t, dividend / divisor);
        }
    }
}
