/*package whatever //do not write package name here */

For given string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.


  T.C = O(N^2)
  S.C = O(1)

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		
	 Scanner sc = new Scanner (System.in);
	 int testCases = sc.nextInt();
	  sc.nextLine(); //  This ensures that the newline character after the integer T is consumed, 
	                 // allowing us to read the strings properly.
	 
	 while(testCases>0){
	 String substr = sc.nextLine();
	 
	 int len = substr.length();
	 int max2kSubstring =0;
	 
	 for(int i=1;i<len;i++){
	     int low = i-1;
	     int high = i;
	     int sumLeftSubstring=0;
	     int sumRightSubstring=0;
	     
	     while(low>=0 && high<len ){
	         sumLeftSubstring+=substr.charAt(low)-'0';
	         sumRightSubstring+=substr.charAt(high)-'0';
	         
	          if(sumLeftSubstring==sumRightSubstring && (high-low+1)>max2kSubstring){
	         max2kSubstring=high-low+1;
	          }
	         
	         low--;
	         high++;
	        
	     }
	         
	     }
	     
	    
	System.out.println(max2kSubstring);
	testCases--;
	}
	}
}
