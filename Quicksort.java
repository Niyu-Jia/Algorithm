
import java.util.*;
public class Quicksort{

  public void sort(int[] data, int start, int end) {
       if (data == null || start >= end) return;
       int i = start, j = end;

       int pivotKey = data[start];

      while (i < j) {
          // if the right pointer is bigger, move it towards left;
          while (i < j && data[j] >= pivotKey) j--;

          // until find the item smaller than pivot,
          if (i < j) data[i++] = data[j];

          //if the left pointer is smaller, move it towards right;
          while (i < j && data[i] <= pivotKey) i++;

          //until find the item bigger than pivot,
          if (i < j) data[j--] = data[i];
      }

       data[i] = pivotKey; // replace the index i with pivot
       sort(data, start, i - 1);
       sort(data, i + 1, end);
   }

   public int kth_smallest(int[] data, int start,int end, int k)
{
      k=k-1;
      //only one element in the array
      if (start==end) return data[start];

       int i = start, j = end;
       int pivotKey = data[start];

      while (i < j) {
          // if the right pointer is bigger, move it towards left;
          while (i < j && data[j] >= pivotKey) j--;

          // until find the item smaller than pivot,
          if (i < j) data[i++] = data[j];

          //if the left pointer is smaller, move it towards right;
          while (i < j && data[i] <= pivotKey) i++;

          //until find the item bigger than pivot,
          if (i < j) data[j--] = data[i];
      }

       data[i] = pivotKey; // replace the index i with pivot

       // 递归左边部分和右边部分
         if(start < i && k < i){
             return kth_smallest(data, k, start, i - 1);
         }
         if(end > j && k > j){
             return kth_smallest(data, k, j + 1, end);
         }
         return data[i]; // i == k

}



   public static void main(String[] args) {
     Quicksort QS= new Quicksort();
     int[] data=new int[]{7,4,5,9,10,1,35};
     int l=data.length-1;
     QS.sort(data,0,l);
     int kth=QS.kth_smallest(data,0,l,4);

     System.out.println(Arrays.toString(data));
      System.out.println(kth);

   }
}
