import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 1. 나보다 큰 값들은 덱 뒤에서 다 빼버린다 (최솟값 유지)
            // "어차피 내가 더 작고 더 늦게까지 살아남으니까!"
            while (!deque.isEmpty() && deque.peekLast().value > now) {
                deque.pollLast();
            }
            // 2. 현재 값을 인덱스와 함께 덱 뒤에 넣는다.
            deque.offerLast(new Node(now,i));

            // 3. 덱 맨아의 값이 윈도우 범위를 벗어났으면 뺸다.
            // (i-L+1)이 현재 윈도우의 시작점
            if(deque.peekFirst().index <= i-L){
                deque.pollFirst();
            }

            // 4. 이제 덱 앞이 무조건 현재 윈도위의 최솟값
            bw.write(deque.peekFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}