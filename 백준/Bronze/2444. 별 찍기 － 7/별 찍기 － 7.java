import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 2 * n - 1; i++) {
            int spaces = i <= n ? n - i : i - n;
            /*
               n+1부터 별의 개수는 2n-1에서 2개씩 줄어들음
               i가 1증가할때 줄어드는 개수는 i-n
               즉 2개씩 줄어드니까 2(i-n)
               result = 2n-1 - 2(i-n) = 2(2n-i)-1
             */
            int stars = i <= n ? 2 * i - 1 : 2 * (2 * n - i) - 1;

            for (int j = 0; j < spaces; j++)
                sb.append(" ");

            for (int j = 0; j < stars; j++)
                sb.append("*");

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
