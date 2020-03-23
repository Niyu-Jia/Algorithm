package algo1;
import java.io.*;
import java.util.*;


public class UF {

  int[] id;
  int[] sz;

  public UF(int N)
  // Initialized the array id
  {
    id = new int[N];
    sz=new int[N];
    for (int i=0; i<N; i++)
    { id[i]=i;
    }
  }

  public int find(int i)
  // Find the root of i
  {
    while (id[i] != i) // if the parent of i is nor i itself
    { id[i]=id[id[i]];// let i's parent be the (parent of i's parent), should be the root
      i=id[i]; // now assign the root value to i
    }

    return i;
  }

  public void union(int a, int b)
  // union pair (a,b)
  {
    int m=find(a); //m: root of a
    int n=find(b); //n: root of b

    if (m==n) return; //already same root

    if (sz[m]<sz[n]) // then n should be the final root after union
    {
      id[m]=n;
      sz[n]=sz[m]+sz[n];
    } //end if
    else
    {
      id[n]=m;
      sz[m]=sz[m]+sz[n];
    } //end else
  }// end union

/*
  public static void main(String[] args)
  {
    UF arr=new UF(10);
    arr.union(1,3);
    arr.union(2,7);
    arr.union(4,3);
    arr.union(5,8);
    arr.union(5,9);
    arr.union(4,6);
    arr.union(9,2);

  }
  */

}
