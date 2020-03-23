
import java.io.*;
import java.util.*;

// For an N by N grids, check whether it percolates from top to bottom
// This class help to find the threshold of the probability that a grid is open
// Using Monte Carlo simulation; tree data structure


public class percolation {

  private class UF {

    int[] id;
    int[] sz;
    private UF(int N)
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
  }

UF unionfind;
int[] order;
int[] state;
int len;

public percolation(int N)
{
  unionfind = new UF(N*N);
  order=new int[N*N];
  state= new int[N*N];
  len= N;


  for (int i=0; i<N*N;i++){
    order[i]=i;
  }
}


public double threshold(){
  double prob=0.0;
  int l=this.len;
  Random rand = new Random();

  // reorder the index (uniform shuffle)
	for (int i = 1; i < this.order.length; i++) {
		int randomIndexToSwap = rand.nextInt(i);
		int temp = this.order[randomIndexToSwap];
		this.order[randomIndexToSwap] = this.order[i];
		this.order[i] = temp;
	}// end of random shuffle

   //for at most l*l draws:
   for (int k=0;k<l*l;k++)
   {
     Integer[] top= new Integer[l];
     Integer[] bottom=new Integer[l];

     int index=this.order[k];
     this.state[index]=1;

     if (index!=0 && this.state[index-1]==1 && (index-1)%l !=l-1 )
     this.unionfind.union(index,index-1);

     if (index !=l*l-1 && this.state[index+1]==1 && (index+1)%l!=0 )
     this.unionfind.union(index,index+1);


     if (index-l>=0 && this.state[index-l]==1)
     this.unionfind.union(index,index-l);

     if (index+l<l*l && this.state[index+l]==1)
     this.unionfind.union(index,index+l);

     //Check percolation for this draw
     //It percolates if first line and bottome line have elements of same root
     for (int j=0;j<l;j++)
      {
       top[j]=this.unionfind.find(j);
       bottom[j]=this.unionfind.find(l*l-1-j);
      }

   Set<Integer> top_set = new HashSet<>(Arrays.asList(top));
   Set<Integer> bottom_set = new HashSet<>(Arrays.asList(bottom));
   top_set.retainAll(bottom_set);
     if (top_set.isEmpty()== false)
     {
       prob=(float)(k+1)/(l*l);
       break;
     } //end if checking empty
   }//end of for loop
return prob;
 }// end of method threshold


public static void main(String[] args) {

// give 10000 trials
int trials=10000;
int n=5;
double prob_sum=0.0;

for (int i=0; i<trials;i++)
{
  percolation PER= new percolation(n);
  prob_sum=PER.threshold()+prob_sum;
}
System.out.println("The prob for any grid to be open to percolate the system is:")
System.out.println(prob_sum/trials);

}



}//end class of percolation
