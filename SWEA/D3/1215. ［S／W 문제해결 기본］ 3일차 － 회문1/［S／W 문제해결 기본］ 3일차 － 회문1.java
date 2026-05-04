import java.io.*;
import java.util.StringTokenizer;

class Solution {
    static char[][] A;
    static int[] dx = {1, 0};
    static int[] dy = {0,1};
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());
            A = new char[8][8];
            for (int i = 0; i < 8; i++) {
                A[i] = br.readLine().toCharArray();
            }
            cnt = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    search(i, j);
                }
            }
            result.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.print(result);
    }

    private static void search(int x, int y) {
        for (int i = 0; i < 2; i++) {
            int nx = x;
            int ny = y;
            StringBuilder sb = new StringBuilder();
            sb.append(A[nx][ny]);
            while (true) {
                nx += dx[i];
                ny += dy[i];

                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8)
                    break;

                sb.append(A[nx][ny]);
                if (sb.length() == N) {
                    if (isPalindrome(sb)) {
                        cnt++;
                    }
                    break;
                }
            }
        }


    }

    private static boolean isPalindrome(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(sb.length() - i - 1);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}