import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
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

        for(int i =1; i<=N; i++){
            Collections.sort(A[i]);
        }

        DFS(V);

        System.out.println();
        visited = new boolean[N+1];

        BFS(V);
    }

    public static void DFS(int index){
        visited[index] = true;
        System.out.print(index+" ");

        for (Integer i : A[index]) {
            if(visited[i] == false){
                DFS(i);
            }
        }
    }

    public static void BFS(int index){
        Queue<Integer> queue = new LinkedList<>();

        visited[index] = true;
        queue.add(index);
        while(!queue.isEmpty()){
            Integer node = queue.remove();
            ArrayList<Integer> integers = A[node];
            for (Integer i : integers) {
                if (visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            System.out.print(node+" ");
        }
    }
}