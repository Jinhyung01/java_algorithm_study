import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n];

        for (int i = 0; i < n; i++) {
            basket[i] = i + 1;
        }
        for(int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;

            int tmp = basket[i];
            basket[i] = basket[j];
            basket[j] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<basket.length;i++) {
            if(i>0)
                sb.append(' ');
            sb.append(basket[i]);
        }
        System.out.print(sb);
    }
}