import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        //A배열 초기화
        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<Edge>();
        }

        //노드 관계 설정
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while(true){
                int i1 = Integer.parseInt(st.nextToken());
                if(i1 == -1){
                    break;
                }
                int i2 = Integer.parseInt(st.nextToken());
                A[n].add(new Edge(i1,i2));
            }
        }

        BFS(1);

        int maxIndex = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[maxIndex] < distance[i]) {
                maxIndex = i;
            }
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(maxIndex);
        Arrays.sort(distance);
        //max = Arrays.stream(distance).max().getAsInt();
        System.out.println(distance[N]);
    }


    public static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        visited[index] = true;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            //System.out.print(poll+" ");
            for (Edge i : A[poll]) {
                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    queue.offer(e);
                    visited[e] = true;
                    distance[e] = v+ distance[poll];
                }
            }
        }
    }
}

class Edge{
    int e;
    int value;

    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}