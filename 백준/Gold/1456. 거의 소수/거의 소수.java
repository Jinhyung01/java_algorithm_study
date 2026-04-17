import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int max = (int) Math.sqrt(B);
        boolean[] isPrime = getSieve(max);
        long cnt = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                long temp = i;
                while (temp <= B / i) {
                    temp *= i;
                    if (temp >= A) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);


    }

    private static boolean[] getSieve(int max) {
        boolean[] isPrime = new boolean[max + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j <= max; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}