import java.util.*;
import java.io.*;
public class Main{
    public static class edge{
        int ori;
        int ngh;
        int wt;
        edge(int a, int b,int w){
            this.ori=a;this.ngh=b;this.wt=w;
        }
    }
    public static class combo implements Comparable<combo>{
        int V;
        String path;
        int wtn;
        combo(int a,String b,int w){
            this.v=a;this.path=b;this.wtn=w;
        }
        public int compareTo(combo o){
            return this.wtn - o.wtn;
        }
    }
    public static class combo2 implements Comparable<combo2>{
        int val;
        int prev;
        int wn;
        combo2(int a,int b,int w){
            this.val=a;this.prev=b;this.wn=w;
        }
        public int compareTo(combo2 o){
            return this.wn - o.wn;
        }
    }
    static boolean pathPresent(ArrayList<edge>[] g, int s, int d , int[] v){
        if(s==d){
            return true;
        }
        v[s]=1;
        for(edge E:g[s]){
            if(v[E.ngh]==0){
                boolean path=pathPresent(g,E.ngh,d,v);
                if(path==true){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isGConnected(ArrayList<edge>[] g,int[] v){
        if (components(g,v).length==1){
            return true;
        }
        else{
            return false;
        }
    }

    static void giveComp(ArrayList<Integer> comp, ArrayList<edge>[] g, int[] v, int a){
        v[a]=1;
        comp.add(a);
        for(edge E:g[a]){
            if (v[E.ngh]==0){
                giveComp(comp,g,v,E.ngh);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> components(ArrayList<edge>[] g, int vr){
        int[] v = new int[vr];
        Arrays.fill(v,0);
        ArrayList<ArrayList<Integer>> cmps = new ArrayList<>();
        for(int i=0;i<vr;i++){
            if(v[i]==0){
                ArrayList<Integer> comp=new ArrayList<>();
                giveComp(comp,g,v,i);
                cmps.add(comp);
            }
        }
        return cmps;
    }
// uses matrix conversion required
    static boolean isBi(int[][] g, int s, int vr){
        int[] type = new int[vr];
        Arrays.fill(type,-1);
        Queue<Integer> que = new ArrayDeque<>();
        que.add(s);
        type[s]=1;
        int a;
        while(que.size()!=0){
            a=que.poll();
            if(g[a][a]==1){
                return false;
            }
            else{
                for(int i=0;i<vr;i++){
                    if(g[a][i]==1 && type[i]==-1){
                        type[i]=1-type[a];
                        que.add(b);
                    }
                    else if(g[a][i]==1 && type[a]==type[i]){
                        return false;
                    }
                }
            }
        }
        return true; 
    }
    
    static void BFS(ArrayList<edge>[] g, int vr){
        Queue<combo> que = new ArrayDeque<combo>();
        int[] v = new int[vr];
        Arrays.fill(v,0);
        combo a;
        while(que.size()>0){
            a=que.poll();
            if(v[a.V]==1){
                v[a.V]=1;
                System.out.println(a.V+" "+a.path);
                for(edge e:g[a.V]){
                    if(v[a.V]==0){
                        que.add(new combo(e.ngh,a.path+e.ngh));
                    }
                }
            }
        }
    }

    static void DFS(ArrayList<edge>[] g, int vr){
        Stack<combo> st = new Stack<combo>();
        int[] v = new int[vr];
        Arrays.fill(v,0);
        combo a;
        while(st.size()>0){
            a=st.poll();
            if(v[a.V]!=1){
                v[a.V]=1;
                System.out.println(a.V+" "+a.path);
                for(edge e:g[a.V]){
                    if(v[a.V]==0){
                        st.add(new combo(e.ngh,a.path+e.ngh));
                    }
                }
            }
        }
    }

    static void Djikstra(ArrayList<edge>[] g, int vr){
        PriorityQueue<combo> pque = new PriorityQueue<combo>();
        int[] v = new int[vr];
        Arrays.fill(v,0);
        combo a;
        while(pque.size()>0){
            a=pque.poll();
            if(v[a.V]!=1){
                v[a.V]=1;
                System.out.println(a.V+" "+a.path+" "+a.wtn);
                for(edge E:g[a.V]){
                    if(v[a.V]==0){
                        pque.add(new combo(E.ngh,a.path+E.ngh,a.wtn+ E.wt));
                    }
                }
            }
        }
    }

    static void prims(ArrayList<edge>[] g, int vr){
        PriorityQueue<combo> pque = new PriorityQueue<combo>();
        pque.add(new combo2(0,-1,0));
        int[] v = new int[vr];
        Arrays.fill(v,0);
        combo a;
        while(pque.size()>0){
            a=pque.poll();
            if(v[a.V]!=1){
                v[a.V]=1;
                System.out.println(a.val+" "+a.prev+" "+a.wn);
                for(edge E:g[a.val]){
                    if(v[a.V]==0){
                        pque.add(new combo2(E.ngh,a.val,E.wt));
                    }
                }
            }
        }
    }

    static void topoSort(ArrayList<edge>[] g, int vr){
        
    }

    static int[][] convert(ArrayList<edge>[] adj,int V){
        int[][] matrix = new int[V][V];
        for(int i = 0; i < V; i++)
        {
            int j =0;
            for(edge E : adj[i]){
                matrix[i][j] = 1;
                j++;
            }
        }
        return matrix;
    }
    
    static void hamiltonianPath(ArrayList<Edge>[] g, int os, int s, HashSet<Integer> v, String path) {
        if (visited.size() == g.length - 1) {
            System.out.print(psf);
            boolean closingEdge = false;
            for(edge E: graph[os]){
                if(E.nbr == s){
                    closingEdge = true;
                    break;
                }
            }
            if(closingEdge){
                System.out.println("*");
            } 
            else{
                System.out.println(".");
            }
            return;
        }
        visited.add(s);
        for (edge E : graph[s]) {
            if (!visited.contains(E.ngh)){
                hamiltonianPath(graph, os, E.ngh, v, path.add(E.ngh));
            }
        }
        visited.remove(s);
    }

//  for is cyclic check if marked two times
}