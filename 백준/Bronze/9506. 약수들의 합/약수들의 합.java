import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            int sum = 1;
            List<Integer> divisors = new ArrayList<>();
            divisors.add(1);

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                    sum += i;

                    int other = n / i;
                    if (other != i) { // 제곱수가 아닌경우만
                        divisors.add(other);
                        sum += other;
                    }
                }
            }
            Collections.sort(divisors);

            if (sum == n) {
                sb.append(n).append(" = ");
                for (int i = 0; i < divisors.size(); i++) {
                    if (i > 0) sb.append(" + ");
                    sb.append(divisors.get(i));
                }
                sb.append("\n");
            } else
                sb.append(n).append(" is NOT perfect.\n");
        }
        System.out.println(sb);
    }

}