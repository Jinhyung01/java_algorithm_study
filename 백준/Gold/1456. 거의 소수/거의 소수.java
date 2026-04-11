import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        boolean[] prime = getPrimeSieve((int) Math.sqrt(B));
        int cnt = 0;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                for (long j = 2; j <= 47; j++) {
                    long num = (long) Math.pow(i, j);
                    if (num >= A && num <= B) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);


    }

    public static boolean[] getPrimeSieve(int end) {
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= end; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j <= end; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}