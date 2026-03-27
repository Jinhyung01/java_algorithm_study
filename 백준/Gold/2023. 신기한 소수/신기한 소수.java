import java.io.*;

public class Main {

    static int N;
    static int[] arr = {2, 3, 5, 7};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            dfs(arr[i], 1);
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int depth) {
        if (depth == N) {
            sb.append(cur).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i += 2) {
            int nNum = cur * 10 + i;
            if (isPrime(nNum)) {
                dfs(nNum, depth + 1);
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}