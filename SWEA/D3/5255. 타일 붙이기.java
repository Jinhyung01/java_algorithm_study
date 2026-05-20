import java.io.*;

public class Solution {

	// D[N] = 2XN 직사각형을 채우는 경우의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] D = new long[N + 1];

			D[1] = 1;
			D[2] = 3;
			D[3] = 6;

			for (int i = 4; i <= N; i++) {
				D[i] = D[i - 1] + 2 * D[i - 2] + D[i - 3];
			}
			sb.append("#").append(t).append(" ").append(D[N]).append("\n");
		}
		System.out.print(sb);
	}
}
