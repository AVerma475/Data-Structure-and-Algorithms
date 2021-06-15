import java.io.*;
import java.util.*;

public class Main {
  static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList < Edge > [] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList < > ();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = Integer.parseInt(br.readLine());
    int dest = Integer.parseInt(br.readLine());
    boolean[] vis = new boolean[vtces];

    printAllPath(graph, src, dest, vis, "", 0);
  }
  //==================================================================================================================================================
  public static void printAllPath(ArrayList < Edge > [] graph, int src, int des, boolean[] vis, String path, int pathSum) {

    if (src == des) {
      System.out.println(path + src + " @ " + pathSum);
      return;
    }

    vis[src] = true;

    for (Edge e: graph[src]) {
      if (!vis[e.nbr]) {
        printAllPath(graph, e.nbr, des, vis, path + src, pathSum + e.wt);
      }
    }

    vis[src] = false;
  }
}
//==================================================================================================================================================
/* =============================================================
Sample I/p

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6

Sample o/p =
0123456 @ 60
012346 @ 50
03456 @ 40
0346 @ 30

*/
