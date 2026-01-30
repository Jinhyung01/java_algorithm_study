import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = Math.max(a, Math.max(b, c));
        int otherSum = a + b + c - max;

        if (max >= otherSum) {
            System.out.println(2*otherSum-1);
        }else{
            System.out.println(a+b+c);
        }
    }
}