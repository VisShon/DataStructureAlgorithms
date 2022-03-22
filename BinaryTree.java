public class binarytree {
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
  
  public static class N {
    Node root;
    int state;

    N(Node root, int state){
      this.state = state;
      this.root = root;
    }
  }
  
  public static preTree(int[] arr){
    Node Root = new Node(arr[0],null,null);
    N bt = new N(Root,1)
    Stack<N> st = new Stack<N>();
    st.push(bt);
    int idx=0;
    while(st.size()>0){
      N top =st.peek();
      if(top.state==1){
        idx++;
        if(arr[idx]!=null){
          top.root.left=new node(arr[idx],null,null);
          N lbt = new N(top.root.left,1);
          st.push(lbt);
        }
        else{
          top.root.left=null;
        }
        top.state++;
      }
      else if(top.state==2){
        idx++;
        if(arr[idx]!=null){
          top.root.right=new node(arr[idx],null,null);
          N rbt = new N(top.root.right,1);
          st.push(rbt);
        }
        else{
          top.root.right=null;
        }
        top.state++;
      }
      else{
        st.pop();
      }
    }
    return Root
  }

  public static Node postTree(int[] arr){
    Node Root = new Node(arr[arr.length-1],null,null,Root);
    N bt = new N(Root,1)
    Stack<N> st = new Stack<>();
    st.push(bt);
    int idx = arr.length-1;
    while(st.size()>0){
      N top =st.peek();
      if(top.state==1){
        idx--;
        if(arr[idx]!=null){
          top.root.right=new node(arr[idx],null,null,top);
          N lbt = new N(top.root.right,1);
          st.push(lbt);
        }
        else{
          top.root.right=null;
        }
        top.state++;
      }
      else if(top.state==2){
        idx--;
        if(arr[idx]!=null){
          top.root.left=new node(arr[idx],null,null,top);
          N rbt = new N(top.root.left,1);
          st.push(rbt);
        }
        else{
          top.root.left=null;
        }
        top.state++;
      }
      else{
        st.pop();
      }
    }
    return Root
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
}