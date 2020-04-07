import java.util.ArrayList;
import java.io.*;

public class DFS{
int V;
ArrayList<Integer>[] adj;
  DFS(int V)
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

  void search(int a,boolean[] marked)
  {
    marked[a]=true;// mark current vertix
    System.out.print(a+"~");

    for (int i : this.adj[a])
    {
      if (!marked[i]) search(i,marked);
    }
  }//end of method search

  void DFS_mimic(int a)
  {
    //a: starting point
    boolean[] marked=new boolean[this.V];
    //call the recursive function:
    search(a,marked);
  }//end of method DFS_mimic

public static void main(String args[])
{
    DFS graph=new DFS(10);
    System.out.println("Search Route:");
    int[] list1=new int[]{0,2,4,7,2,3,5,9,6,6};
    int[] list2=new int[]{3,1,1,5,5,4,9,0,2,8};
    for(int i=0;i<10;i++)
    {
      graph.connect(list1[i],list2[i]);
    }

    graph.DFS_mimic(0);
    System.out.println();
}


}
