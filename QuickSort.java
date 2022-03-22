//time complexity Ω(n log(n))  Θ(n log(n))  O(n^2)
public class QuickSort {
    static int partition(int[] arr, int l, int r){
        int p = arr[r];
        int i = (l - 1);
        for(int j = l; j <= r - 1; j++){
            if (arr[j] < p){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return (i + 1);
    }
    static void quickSort(int[] arr, int l, int r){
        if (l < r){
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }
}
