import java.util.*;
public class Main{
    
    static ArrayList<Edge>[] graph;
    
    public static void main(String[] args){
        int vtx = 7;
        graph = new ArrayList[vtx];
        for(int i=0; i < vtx; i++)
        {
            graph[i] = new ArrayList();
        }
        
        int[][] data = {
            {0,1,10},
            {0,3,40},
            {1,2,10},
            {2,3,10},
            {3,4,2},
            {4,5,3},
            {4,6,8},
            {5,6,3}
        };
        
        for(int[] arr : data)
        {
            addEdge(arr[0], arr[1], arr[2]);
        }
        
        
        display();
        
    }
    
    public static void addEdge(int src, int des, int wt){
        graph[src].add(new Edge(src, des, wt));
        graph[des].add(new Edge(des, src, wt));
    }
    
    
    public static void display(){
        for(int i = 0; i < graph.length; i++)
        {
            String str = "[" + i + "] =>";
            for(Edge e : graph[i])
            {
                str += "(" + e.src +"->" + e.des + "@" + e.wt +") ";
            }
            System.out.println(str);
        }
    }
}

class Edge{
    int src;
    int des;
    int wt;
    
    public Edge(int a, int b, int c)
    {
        src = a;
        des = b;
        wt = c;
    }
}
