import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i =1; i<=N; i++){
            deque.addLast(i);
        }
        while(deque.size() != 1){
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }
        System.out.println(deque.getLast());
    }
}


