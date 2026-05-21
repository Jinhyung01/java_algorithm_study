import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static int[] A;
	static int N, K, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = new int[N];
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int idx, int sum) {
		if (sum == K) {
			result++;
			return;
		}
		if (idx >= N || sum > K)
			return;

		dfs(idx + 1, sum + A[idx]);
		dfs(idx + 1, sum);
	}
}
