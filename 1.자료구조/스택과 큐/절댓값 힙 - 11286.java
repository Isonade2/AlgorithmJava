import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;
                }

                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num != 0){
                queue.add(num);
            }else{
                Integer n = queue.poll();
                if(n == null){
                    System.out.println(0);
                    continue;
                }
                System.out.println(n);
            }
        }
    }
}


