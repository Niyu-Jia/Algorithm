import java.util.*;
import java.io.*;

public class BFS{
int V;
ArrayList<Integer>[] adj;

  BFS(int V)
  {
    this.V=V;
    //ArrayList<Integer>[] this.adj=new ArrayList[V];
    this.adj=new ArrayList[V];
    System.out.println("Vetices Number: "+this.adj.length);
    for (int i=0;i<V;i++)

    {this.adj[i]=new ArrayList<Integer>();}

  }

  void connect(int a,int b)
  {
    this.adj[a].add(b);
    this.adj[b].add(a);
  }//end of method connect

  void search(int a)
  {
    //a: statring point
    boolean[] visited=new boolean[V];

    //create queue for BFS
    Queue<Integer> queue=new LinkedList<Integer>();
    visited[a]=true;
    queue.add(a);

    //repeat until queue is empty
    while (queue.size()!=0)
    {
      a=queue.poll();
      System.out.print(a+"~");
      // get all adjacent vertices; if it is not visited, mark and enqueue import junit.framework.TestCase;
      for (int i:this.adj[a])
      {
        if (!visited[i])
        {visited[i]=true;
        queue.add(i);}
      }
    }
  }//end of method search

public static void main(String[] args) {
  BFS graph=new BFS(10);
  System.out.println("Search Route:");
  int[] list1=new int[]{0,2,4,7,2,3,5,9,6,6};
  int[] list2=new int[]{3,1,1,5,5,4,9,0,2,8};
  for(int i=0;i<10;i++)
  {
    graph.connect(list1[i],list2[i]);
  }

  graph.search(0);
  System.out.println();
}//end of main

}
