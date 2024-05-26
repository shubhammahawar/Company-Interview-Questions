Given an array of strings arr[] of length n representing non-negative integers, arrange them in a manner, such that, after concatanating them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

Example 1:

Input: 
n = 5
arr[] =  {"3", "30", "34", "5", "9"}
Output: "9534330"
Explanation: 
Given numbers are  {"3", "30", "34", "5", "9"}, 
the arrangement "9534330" gives the largest value.


T.C = O(nlogn)

import java.util.*;
import java.io.*;


//User function Template for Java

class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        Arrays.sort(arr, new Comparator<String>(){
            
            @Override
            public int compare(String X, String Y){
                String XY = X+Y;
                String YX = Y+X;
                
                int comparison = XY.compareTo(YX);
                return comparison==0?0:(comparison>0?-1:1);
            }
        });
        String result="";
        for(int i=0;i<arr.length;i++){
            result+=arr[i];
        }
        return result;
    }
}
