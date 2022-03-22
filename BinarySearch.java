//time complexity = O(logn)
public class BinarySearch {
    static int binarySearch(int[] arr, int n, int l, int r){
        if (r>=1){
            int mid = (r-l)/2;
            if(arr[mid]==n){
                return mid;
            }
            else if(arr[mid]<n){
                return binarySearch(arr, n, mid+1, r);
            }
            else{
                return binarySearch(arr, n, l, mid-1);
            }
        }
        else{
            return -1;
        }
    }
}