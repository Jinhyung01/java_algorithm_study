import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num<x)
                sb.append(num).append(" ");
        }

        if(sb.length()>0)
            sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }
}


