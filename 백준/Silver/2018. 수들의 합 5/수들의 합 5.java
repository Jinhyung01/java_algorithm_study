import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int sum = 1, i = 1, j = 1;
        while (j < N) {
            if (sum < N) {
                j++;
                sum += j;
            } else if (sum > N) {
                sum -= i;
                i++;
            } else {
                cnt++;
                j++;
                sum = sum + j - i;
                i++;
            }
        }
        System.out.println(cnt);
    }
}