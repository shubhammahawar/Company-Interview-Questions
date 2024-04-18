Given an array of N positive integers, print k largest elements from the array.

https://www.geeksforgeeks.org/problems/k-largest-elements3736/1

T.C = O(N*logK)
S.C = O(k)

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
