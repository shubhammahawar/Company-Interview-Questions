Find the n’th term in Look-and-say (Or Count and Say) Sequence. The look-and-say sequence is the sequence of the below integers: 
1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, …

Time complexity: O(kn),since we are calling the function n times and for k length of the string
Auxiliary Space: O(kn),stack space needed.

https://www.geeksforgeeks.org/look-and-say-sequence/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static String findNthPattern(int n){
        if(n==1){
            return "1";
        }
            
            String str = findNthPattern(n-1);
            StringBuilder res=new StringBuilder();
            Stack<Character> st = new Stack<>();
            
            for(int i=0;i<=str.length();i++){
                // case if we have reached the end of the string or stack is not empty and 
                // current element is not same as the peek element 
         //       Eg - 21 -> we are at inde 1 i.e 1 -> current element and stack top element is 2
         
                if(i==str.length() || (!st.isEmpty() && st.peek()!=str.charAt(i))){
                    res.append(st.size()).append(st.peek());
                    st.clear();
                }
                if(i!=str.length()){ // case when stack is empty and we have not reached at the end of a string
                    st.push(str.charAt(i));
                }
            }
            return res.toString();
        }
    
    static String lookandsay(int n) {
        //your code here
        return findNthPattern(n);
    }
}
