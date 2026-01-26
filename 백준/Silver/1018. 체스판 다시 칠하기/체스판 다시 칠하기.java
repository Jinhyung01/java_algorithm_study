import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 맨 왼쪽 위칸 색
                char c = arr[i][j];
                int cnt = 0;
                for (int a = i; a < i + 8; a++) {
                    for (int b = j; b < j + 8; b++) {
                        if (a % 2 == 0) {
                            if (b % 2 == 0 && c != arr[a][b]) {
                                cnt++;
                            } else if (b % 2 != 0 && c == arr[a][b])
                                cnt++;
                        } else {
                            if (b % 2 == 0 && c == arr[a][b]) {
                                cnt++;
                            } else if (b % 2 != 0 && c != arr[a][b])
                                cnt++;
                        }
                    }
                }
                cnt = Math.min(cnt, 64 - cnt); // 체스판 뒤집는 경우
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }
}