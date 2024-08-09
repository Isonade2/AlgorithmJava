import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            A[i1].add(i2);
            A[i2].add(i1);
        }
        int count = 0;
        for(int i = 1; i<=N; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int index){
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        visited[index] = true;
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            ArrayList<Integer> integers = A[pop];
            for (Integer i : integers) {
                if(visited[i] == false){
                    visited[i] = true;
                    stack.push(i);
                }
            }
            //System.out.print(pop+" ");
        }
    }
}