import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        boolean[][] arr = new boolean[100][100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            for (int a = y; a <= y + 9; a++) {
                for (int b = x; b <= x + 9; b++) {
                    arr[99 - a][b] = true;
                }
            }

        }
        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j])
                    area++;
            }
        }
        System.out.println(area);
    }

}