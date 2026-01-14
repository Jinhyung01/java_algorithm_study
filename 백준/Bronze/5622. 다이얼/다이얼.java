import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Character, Integer> map = new HashMap<>();

    static {
        for (char c = 'A'; c <= 'C'; c++) {
            map.put(c, 2);
        }
        for (char c = 'D'; c <= 'F'; c++) {
            map.put(c, 3);
        }
        for (char c = 'G'; c <= 'I'; c++) {
            map.put(c, 4);
        }
        for (char c = 'J'; c <= 'L'; c++) {
            map.put(c, 5);
        }
        for (char c = 'M'; c <= 'O'; c++) {
            map.put(c, 6);
        }
        for (char c = 'P'; c <= 'S'; c++) {
            map.put(c, 7);
        }
        for (char c = 'T'; c <= 'V'; c++) {
            map.put(c, 8);
        }
        for (char c = 'W'; c <= 'Z'; c++) {
            map.put(c, 9);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int length = line.length();
        int sum = length;
        for (int i = 0; i < length; i++) {
            char c = line.charAt(i);
            sum += map.get(c);
        }
        System.out.print(sum);
    }
}