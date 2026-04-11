import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;
        
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                result -= result / p;

                // n에서 소인수 p를 모두 제거
                while (n % p == 0) {
                    n /= p;
                }
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        System.out.println(result);
    }
}