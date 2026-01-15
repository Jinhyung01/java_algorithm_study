import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int x=0;
        int y=0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max){
                    max = num;
                    x=i+1;
                    y=j+1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(x).append(' ').append(y);
        System.out.print(sb);
    }
}