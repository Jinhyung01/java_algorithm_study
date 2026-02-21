import java.io.*;
import java.util.*;


public class Main {
    static int[] checkArr = new int[4]; // 비밀번호 체크 배열
    static int[] myArr = new int[4]; // 현재 상태 배열
    static int checkSecret = 0; // 몇 개의 문자가 조건을 만족했는지

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S_len = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
        int P_len = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        int result = 0;

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            // 요구하는 최소개수가 0이라면 이미 조건 만족한것이므로 count++;
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }
        // 첫번쨰 윈도우 설정
        for (int i = 0; i < P_len; i++) {
            Add(dna[i]);
        }
        if (checkSecret == 4) result++;

        // 슬라이딩 윈도우 진행
        for (int i = P_len; i < S_len; i++) {
            int j = i - P_len;

            Add(dna[i]); // 오른쪽 끝 추가
            Remove(dna[j]); // 왼쪽 끝 제거
            if (checkSecret == 4) result++;
        }
        System.out.println(result);
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}