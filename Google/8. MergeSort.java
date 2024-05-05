Q. Write a merge sort alogirithm 

T.C = O(N*LOGN) // O(N) - For merge  O(LOGN) - To Divide and Conquer
S.C = O(N)

import java.io.*;
import java.util.*;

class MergeSort{

public static void merge(int arr[], int low, int mid, int high){

int left = low;
int right = mid+1;
ArrayList<Integer>temp = new ArrayList<>();

while(left<=mid && right<=high){

if(arr[left]<=arr[right])
temp.add(arr[left++]);

else
temp.add(arr[right++]);

}

while(left<=mid)
temp.add(arr[left++]);

while(right<=high)
temp.add(arr[right++]);

for(int i=low;i<=high;i++)
arr[i]=temp.get(i-low);


}


public static void mergeSorting(int arr[], int low, int high){

if(low>=high)
return;

int mid = (low+high)/2;
mergeSorting(arr, low, mid); // Dividing the array first half
mergeSorting(arr, mid+1, high);  // Dividing the array second half
merge(arr,low,mid,high);  //merging the array
}

public static void main(String args[]){

int arr[] = {4,1,8,9,2,5,2,1,3};
int n = arr.length;

mergeSorting(arr,0,n-1);
System.out.println("Array after Merge Sort ");
for(int ele:arr)
System.out.print(ele+" ");
}

}
