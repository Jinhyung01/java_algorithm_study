import java.io.*;

public class Main {

    static int[] arr = {2, 3, 5, 7};
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            amazingPrime(0, arr[i]);
        }

        System.out.print(sb);
    }

    private static void amazingPrime(int depth, int num) {
        if (depth == N - 1) {
            sb.append(num).append('\n');
            return;
        }
        for (int i = 1; i <= 9; i += 2) {
            int tmp = num * 10 + i;
            if (isPrime(tmp)) {
                amazingPrime(depth + 1, tmp);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}