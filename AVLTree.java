public class AVL {
  public static class Node {
      int data;
      Node left;
      Node right;
      Node parentNode;

      Node(int data, Node left, Node right, Node parent){
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
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
    Node Root = new Node(arr[0],null,null,Root);
    N bt = new N(Root,1)
    Stack<N> st = new <N>();
    st.push(bt);
    int idx=0;
    while(st.size()>0){
      N top =st.peek();
      if(top.state==1){
        idx++;
        if(arr[idx]!=null){
          top.root.left=new node(arr[idx],null,null,top);
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
          top.root.right=new node(arr[idx],null,null,top);
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
    Node temp = new Node();
    temp.data=root.data;
    temp.right=copyOf(root.right);
    temp.left=copyOf(root.left);
    temp.parent=root.parent;
    return temp;
  }

  public static Node minNode(Node root){
    Node temp = root;
    while(temp.left!=null){
      temp=temp.left;
    }
    return temp;
  }

  public static Node maxNode(Node root){
    Node temp = root;
    while(temp.right!=null){
      temp=temp.right;
    }
    return temp;
  }

  public static boolean isPresent(Node root, int x){
    if(root==null){
      return false;
    }
    if(root.data==x){
      return true;
    }
    else if(x<root.data){
      return isPresent(root.left,x);
    }
    else{
      return ispresent(root.right,x);
    }
  }

  public static Node successor(Node root, Node x){
    if(root.right!=null){
      return minNode(root.right);
    }
    else{
      Node y = root.parent;
      while(y!=null && y.right=x){
        x=y;
        y=x.parent;
      }
      return y;
    }
  }

  public static Node predecessor(Node root, Node x){
    if(root.left!=null){
      return minNode(root.left);
    }
    else{
      Node y = root.parent;
      while(y!=null && y.left=x){
        x=y;
        y=x.parent;
      }
      return y;
    }
  }

  public static boolean isBST(Node root, int min, int max ){
    if(root==null){
      return true;
    }
    else{
      return(root.data>min && root.data<max && isBST(root.left,min,root.data) && isBST(root.right, root.data, max));
    }
  }

  public static int bal(Node node){
    if(node==null){
      return 0;
    }
    return height(node.left)-height(node.right);
  }

  public static Node rotate(Node node, String str){
    if(str=='left'){
      Node a=node.right;
      Node child=a.left;
      a.left=node;
      node.right=child;
      return a;
    }
    else{
      Node a=node.left;
      Node child=a.right;
      a.right=node;
      node.left=child;
      return a;
    }
  }

  public static Node insert(Node root, int val){
    if(root==null){
      root = new Node(val,null,null,root);
    }
    else{
      if(val<=root.data){
        root.left=insert(root.left,val);
      }
      else{
        root.right=insert(root.right,val);
      }
    }

    int b=bal(root)
    if(b>1 && val<root.left.data){
      return rotate(root,'right');
    }
    else if(b>1 && val>root.left.data){
      root.left = rotate(root,'left');
      return rotate(r,'right');
    }
    else if(b<-1 && val<root.right.data){
      root.right = rotate(root,'right');
      return rotate(r,'left');
    }
    else if(b<-1 && val>root.right.data){
      return rotate(root,'left');
    }
    else{
      return root;
    }
  }

  public static Node delete(Node root, int val){
    if(root==null){
      return root;
    }
    if(val<root.val){
      root.left=delete(root.left,val);
    }
    else if(val>root.val){
      root.right=delete(root.right,val);
    }
    else{
      if(root.right==null){
        return root.left;
      }
      else if(root.left==null){
        return root.right;
      }
      else{
        root.data=minNode(root.right).data;
        root.right=delete(root.right,root.data);
      }
    }
    if(root == null){
      return root;
    }
    int b=bal(root)
    if(b>1 && bal(root.left)>=0){
      return rotate(node,'right');
    }
    else if(b>1 && bal(root.left)<0){
      node.left = rotate(node,'left');
      return rotate(r,'right');
    }
    else if(b<-1 && bal(root.right)>0){
      node.right = rotate(node,'right');
      return rotate(r,'left');
    }
    else if(b<-1 && bal(root.right)<=0){
      return rotate(node,'left');
    }
    else{
      return root;
    }
  }
}