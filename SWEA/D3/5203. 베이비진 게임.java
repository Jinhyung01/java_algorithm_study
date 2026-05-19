import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int winner = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[10];
            int[] B = new int[10];
            for (int i = 1; i <= 12; i++) {
                if (i % 2 != 0) {
                    A[Integer.parseInt(st.nextToken())]++;
                    if (isWinner(A)) {
                        winner = 1;
                        break;
                    }
                } else {
                    B[Integer.parseInt(st.nextToken())]++;
                    if (isWinner(B)) {
                        winner = 2;
                        break;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(winner).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isWinner(int[] arr) {
        for (int i = 0; i <= 9; i++) {
            if (arr[i] >= 3) return true;

            if (i <= 7) {
                if (arr[i] >= 1 && arr[i + 1] >= 1 && arr[i + 2] >= 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
