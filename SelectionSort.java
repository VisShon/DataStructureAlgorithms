//time complexity Ω(n^2)  Θ(n^2)  O(n^2)
public class SelectionSort {
    static void selectionsort(int arr[], int l){
        for(int i=0;i<l;i++){
            int min=i;
            for(int j=i;j<l;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }
}
