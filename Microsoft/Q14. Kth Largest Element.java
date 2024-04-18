Given an array of N positive integers, print k largest elements from the array.

https://www.geeksforgeeks.org/problems/k-largest-elements3736/1

T.C = O(N*logK)
S.C = O(k)



Explanation :


Consider the array a = {3, 7, 2, 9, 1} and k = 3.

Initial State: PriorityQueue is empty.

Inserting Elements:

Insert 3: PriorityQueue = {3}
Insert 7: PriorityQueue = {3, 7}
Insert 2: PriorityQueue = {2, 3, 7}
Insert 9: PriorityQueue = {2, 3, 7, 9} (Size > k, remove smallest element)
Insert 1: PriorityQueue = {1, 2, 3, 7, 9} (Size > k, remove smallest element)
Result:

After inserting all elements, the PriorityQueue contains the elements {1, 2, 3, 7, 9}.
Since k = 3, we only need the top k elements from the PriorityQueue, which are {7, 9, 3}.

// Java code for k largest elements in an array


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;


class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> list = ob.kLargest(arr, n, k);
            for(int i = 0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here 
        PriorityQueue<Integer>kLargestElements = new PriorityQueue<>();
        
        for(int ele:arr){
            kLargestElements.add(ele);
            
            if(kLargestElements.size()>k){  // store the elements in priority queue i.e min heap and when size will cross the size of kth largest remove the minimum element from queue
                                           // this way it will maintain the priority queue of size k with largest k elements.
                kLargestElements.poll(); 
            }
        }
        
        ArrayList<Integer>ans = new ArrayList<>();
        while(!kLargestElements.isEmpty()){
          
            ans.add(kLargestElements.poll()); 
        }
        Collections.reverse(ans); // reverse to get highest to lowest
        return ans;
    }
}
