import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = getSieve(10000000);
        for (int i = N; i < isPrime.length; i++) {
            if (isPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return original == reversed;
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