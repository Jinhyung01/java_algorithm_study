import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] alphabet = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

        for (String a : alphabet) {
            str = str.replace(a, "*");
        }

        System.out.print(str.length());

    }
}