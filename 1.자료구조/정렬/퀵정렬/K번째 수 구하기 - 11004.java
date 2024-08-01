import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr);
        System.out.print(arr[K-1]);
    }

    private static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    private static void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr,start,end);
        if(start < part2 - 1){
            quickSort(arr, start, part2-1);
        }
        if(part2 < end) {
            quickSort(arr,part2,end);
        }
    }
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }
    private static void swap(int[] arr, int start, int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
    private static void printArray(int[] arr){
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }
}




