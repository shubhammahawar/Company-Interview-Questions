Given a string s of size N. The task is to find the largest substring which consists of the same characters
Examples: 
 

https://www.geeksforgeeks.org/largest-substring-with-same-characters/

Input : s = “abcdddddeff” 
Output : 3,5 || 3 - starting index & 5- length of the string 
Substring is “ddddd”

T.C = O(N)
S.C = O(1)





/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    public static int[] findLongestSameRepeating(String str){
        int ans=0;
        int temp=1;
        int index=0;
        int i=1;
        
        for( i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                temp++;
            }
            else{
               // ans=Math.max(ans,temp);
                if(temp>ans){
                    ans=temp;
                    index=i-temp;
                }
                temp=1;
            }
        }
         if(temp>ans){
                    ans=temp;
                    index=i-temp;
                }
        int arr[]= new int[2];
        arr[0]=index;
        arr[1]=ans;
        return arr;
    } 
    
    
	public static void main (String[] args) {
		
		String str = "aabbb22rrrrr345571111111";
		int arr[]=findLongestSameRepeating(str);
		System.out.println("Starting index of substring "+arr[0]);
		System.out.println("Length of a longest substring with same characters "+arr[1]);
		
	}
}
