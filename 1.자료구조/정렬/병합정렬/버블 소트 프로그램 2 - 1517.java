import java.io.*;
import java.util.*;

public class Main {
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr);

        System.out.println(result);



    }

    private static void mergeSort(int[] arr){
        int[] tmp = new int[arr.length];
        mergeSort(arr,tmp,0,arr.length-1);
    }
    private static void mergeSort(int[] arr, int[] tmp, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(arr,tmp,start,mid);
            mergeSort(arr,tmp,mid+1,end);
            merge(arr,tmp,start,mid,end);
        }
    }
    private static void merge(int[] arr, int[] tmp, int start, int mid, int end){
        for(int i = start; i<=end; i++){
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid+1;
        int index = start;
        while(part1 <= mid && part2 <= end){
            if(tmp[part1] <= tmp[part2]){
                arr[index] = tmp[part1];
                part1++;

            }else {
                arr[index] = tmp[part2];
                result = result + part2 - index;
                part2++;
            }
            index++;
//            for(int i = 0; i<=mid -part1; i++){
//                arr[index + i] = tmp[part1 + i];
//            }
        }
        if(part1 > mid){
            while(part2 <= end){
                arr[index] = tmp[part2];
                index++;
                part2++;
            }
        }else{
            while(part1 <= mid){
                arr[index] = tmp[part1];
                index++;
                part1++;
            }
        }
    }
}




