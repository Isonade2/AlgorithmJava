
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            A[i] = new ArrayList<Integer>();
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            A[n1].add(n2);
            A[n2].add(n1);
        }

        for(int i =0; i<N; i++){
            DFS(i,1);
            if(arrive)
                break;
        }
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }
    public static void DFS(int v,int depth){
        if(depth == 5){
            arrive = true;
            return;
        }

        if(visited[v]){
            return;
        }
        visited[v] = true;
        for (Integer i : A[v]) {
            if(!visited[i]){
                DFS(i,depth+1);
            }
        }
        visited[v] = false;
    }

}