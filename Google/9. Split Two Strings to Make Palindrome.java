Q). You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.

When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.

Return true if it is possible to form a palindrome string, otherwise return false.

Notice that x + y denotes the concatenation of strings x and y.

Example :

Input: a = "ulacfd", b = "jizalu"
Output: true
Explaination: Split them at index 3:
aprefix = "ula", asuffix = "cfd"
bprefix = "jiz", bsuffix = "alu"
Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.

Time Complexity = O(N)

Leetcode Link :
https://leetcode.com/problems/split-two-strings-to-make-palindrome/description/

Intuition is :
Find the substring_of_A(0,left) == reverse_of( substring_of_B( right, B.length() ) -----(1)
Find whether A(left,right) is a palindrome or not  -----2
or Find whether B(left,right) is a plaindrome or not

If any of the case is palindrome it means we can get the common index to split it into 2 such that first half of one string
is reverse of 2nd half of other string i.e plaindrome.

Discussed Leetcode solution :
https://leetcode.com/problems/split-two-strings-to-make-palindrome/solutions/891646/java-greedy-explanation-to-o-n-solution/



class Solution {

   public boolean validateLeftToRightToGetCommonIndex(String str,
   int left,int right){
    

    while(left<right){
        if(str.charAt(left)!=str.charAt(right))
        break;

        left++;
        right--;
    }
    return (left>=right);
   }


public boolean validateCombination(String a, String b){

        int len1=a.length();
        int len2=b.length();

        int left = 0;
        int right = len2-1;

        while(left<right){
            if(a.charAt(left)!=b.charAt(right))
            break;

            left++;
            right--;
        }

        return ( validateLeftToRightToGetCommonIndex(a,left,right) || 
        validateLeftToRightToGetCommonIndex(b,left,right) );
}



    public boolean checkPalindromeFormation(String a, String b) {
     return validateCombination(a,b) || validateCombination(b,a);

    }
}
