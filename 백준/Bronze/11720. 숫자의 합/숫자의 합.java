import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            int num = nums.charAt(i) - '0';
            sum += num;
        }
        System.out.print(sum);

    }
}