public class heap {
  public static class Node {
      int data;
      Node left;
      Node right;

      Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
      }
    }

  public static void heapify(int[] arr,int n,int i){
    int m = i;
    int l = 2*i+1;
    int r = 2*i+2;
    if(l<n && arr[l] > arr[m]){
      m=l;
    }
    if(r<n && arr[r]>arr[m]){
      m=r;
    }
    if(m!=i){
      int swap = arr[i];
      arr[i]=arr[m];
      arr[m]=swap;
      heapify(arr,n,m)
    }
  }

  public static Node buildHeap(int arr[]){
    int n = arr.length;
    int startIdx = (n / 2) - 1;
    for (int i = startIdx; i >= 0; i--){
      heapify(arr, n, i);
    }
    Node root = insertLevelOrder(arr,root,0);
  }

  public Node insertLevelOrder(int[] arr, Node root,int i){
      if (i < arr.length){
        Node temp = new Node(arr[i]);
        root = temp;
        root.left = insertLevelOrder(arr, root.left,2 * i + 1);
        root.right = insertLevelOrder(arr, root.right,2 * i + 2);
      }
      return root;
  }

  public static void display(Node root,String s){
    if(root!=null){
      if(s=='pre'){
        System.out.print(" "+root.data);
        display(root.left,'pre');
        display(root.right,'pre');
      }
      else if(s=='in'){
        display(root.left,'in');
        System.out.print(" "+root.data);
        display(root.right,'in');
      }
      else if(s=='post'){
        display(root.left,'post');
        display(root.right,'post');
        System.out.print(" "+root.data);
      }
    }
  }

  public static int count(Node root){
    if(root==null){
      return 0;
    }
    else{
      return 1+count(root.left)+count(root.right);
    }
  }

  public static int height(Node root){
    if(root==null){
      return(0);
    }
    else
      return 1+max(height(root.left),height(root.left));
  }

  public static Node copyOf(Node root){
    if(root==null){
      return null;
    }
    Node temp = new Node(root.data,copyOf(root.left),copyOf(root.right));
    return temp;
  }

  public static void mergeHeap(int[] arr,int[] a,int[] b){
    for(int i = 0;i<a.length;i++){
      arr[i]=a[i];
    }
    for(int j = 0;j<b.length;j++){
      arr[a.length+i]=b[i];
    }
    int l = a.length+b.length;
    for(int k = l/2-1;k>=0;k--){
      heapify(arr,l,i)
    }
  }

  public static void heapSort(int arr[]){
    int n = arr.length;
    for(int i = 0;i<n;i++){
      heapify(arr,n,i);
    }
    for(int i = n-1;i>0;i--){
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr,i,0);
    }
  }

  public static void printArray(int arr[], int n){
    for (int i = 0; i < n; ++i){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public void delete(int[] arr){
    int n = arr.length;
    int a = arr[n-1];
    arr[0] = a;
    n=n-1
    heapify(arr,n,0);
  }

  public void insert(int[] arr,int val){
    int[] a = new int[n+1];
    for(int i=0;i<arr.length;i++){
      a[i]=arr[i]
    }
    a[n]=val;
    n=arr.length;
    n+=1;
    arr=a;
    heapify(arr,n,0);
  }
}