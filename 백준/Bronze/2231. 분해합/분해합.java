import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 1; i <N; i++) {
            String str = String.valueOf(i);
            int sum = i;

            for (int a = 0; a < str.length(); a++) {
                int n = str.charAt(a) - '0';
                sum += n;
            }
            if(sum == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}

