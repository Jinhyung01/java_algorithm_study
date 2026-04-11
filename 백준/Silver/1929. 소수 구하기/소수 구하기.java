import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] prime = getSieve(N);
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if(prime[i])
                sb.append(i).append('\n');
        }
        System.out.println(sb);

    }

    private static boolean[] getSieve(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i*i <= max; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j <= max; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}