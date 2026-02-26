import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        myData[] A = new myData[N];
        for (int i = 0; i < N; i++) {
            A[i] = new myData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);
        int Max = 0;
        for (int i = 0; i < N; i++) {
            if(Max<A[i].index - i){
                Max = A[i].index - i;
            }
        }
        System.out.println(Max+1);

    }


    static class myData implements Comparable<myData> {
        int value;
        int index;

        public myData(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(myData o) {
            return this.value - o.value;
        }
    }


}