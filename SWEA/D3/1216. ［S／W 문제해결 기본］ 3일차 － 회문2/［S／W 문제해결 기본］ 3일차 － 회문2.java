import java.io.*;

class Solution {
    static char[][] A;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int T;
    static int maxLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            T = Integer.parseInt(br.readLine());
            A = new char[100][100];
            for (int i = 0; i < 100; i++) {
                A[i] = br.readLine().toCharArray();
            }
            maxLength = 1;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    search(i, j);
                }
            }
            result.append("#").append(T).append(" ").append(maxLength).append("\n");
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

                if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100)
                    break;

                sb.append(A[nx][ny]);
                if (isPalindrome(sb) && maxLength < sb.length()) {
                    maxLength = sb.length();
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