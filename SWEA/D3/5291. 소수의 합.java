import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long sum = 0;
            boolean[] sieve = getSieve(b - 1);
            for (int i = a + 1; i < sieve.length; i++) {
                if (sieve[i]) {
                    sum += i;
                }
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean[] getSieve(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (!isPrime[i]) continue;

            for (int j = i * i; j <= max; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
