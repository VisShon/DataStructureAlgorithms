//time complexity Ω(n)	Θ(n^2)	O(n^2)
public class BubbleSort {
    static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = n-1; j >0; j--){
                if (arr[j-1] > arr[j])
                {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
