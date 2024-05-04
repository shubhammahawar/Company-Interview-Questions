/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Sorting {


// In Insertion Sort our target is to place the element to its actual position
// So for every iteration we are placing the elements to its actual location in sorted array

Time Complexity :
Worst case = O(N*N)
Average Case = O(N*N)
Best Case = O(N) - When array is already in sorted order (ascending order) - only outer loop runs and 
                   while loop will run only once.
                   

public static void insertionSort(int arr[], int n){

for(int i=0;i<n;i++){

int j=i;
while(j>0 && arr[j]<arr[j-1]){
int temp=arr[j];
arr[j]=arr[j-1];
arr[j-1]=temp;
j--;
}
}

System.out.println("Array after insertion sort ");
for(int ele:arr)
System.out.print(ele+" ");

 System.out.println();

}


// In Bubble Sort target is to compare the adjacnet elements and
place the largest element to its correct place at last in every iteration

Time Complexity :
Worst case = O(N*N)
Average Case = O(N*N)
Best Case = O(N) --- when array already is in sorted order(ascending) and the inner loop runs 'N' times
                     and outer loop will run just once.

public static void bubbleSort(int arr[], int n){

for(int i=n-1;i>=0;i--){
int didSwap =0;

for(int j=0;j<i;j++){

if(arr[j]>arr[j+1])
{
int temp = arr[j];
arr[j]=arr[j+1];
arr[j+1]=temp;
didSwap=1;
}
}
if(didSwap==0)
break;

}

System.out.println("Array after bubble sort ");
for(int ele:arr)
System.out.print(ele+" ");

 System.out.println();
}


// In Selection sort target is to find the minimal element in the unsorted part and swap it with the first element of
// unsorted part array. This way array starts getting sorted in ascending order from start to end.

Time Complexity :
Worst case = O(N*N)
Average Case = O(N*N)
Best Case = O(N*N)

public static void selectionSort(int arr[], int n){

for(int i=0;i<n;i++){
int mine = i;

for(int j=i;j<n;j++){

if(arr[j]<arr[mine])
mine=j;

}
int temp = arr[mine];
arr[mine]=arr[i];
arr[i]=temp;
}

System.out.println("Array after selection sort ");
for(int ele:arr)
System.out.print(ele+" ");

 System.out.println();
}
public static void main(String args[]){

int arr[] = {1,10,4,5,1,-2,3};
int n=arr.length;

selectionSort(arr, n);
bubbleSort(arr, n);
insertionSort(arr,n);

}
}
