import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] count = new int[26];
        char[] arr = str.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - 'A']++;
        }
        int max = Integer.MIN_VALUE;
        char result = '?';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                result = (char) (i + 'A');
            } else if (count[i] == max) {
                result = '?';
            }
        }
        System.out.print(result);
    }
}
