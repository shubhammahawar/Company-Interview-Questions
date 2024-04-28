Given a binary tree (values are unique), and a vector of nums
e.g.

      0
    /   \
  1      2 
/   \
3   4

determine the nums is good or bad

good: the nums position is sorted according to the inorder sequence
bad: the nums position is not sorted according to the inorder sequence
e.g.
inorder of the tree = 3 1 4 0 2
[1 4 2] -> good
[3 1 0] -> good
[3 4 1] -> bad because 4 is after 1 in inorder traversal sequence

T.C = O(N) 



import java.util.*;
import java.io.*;


class TreeNode{

int val;
TreeNode left, right;

TreeNode(int val){
this.val = val;
left=null;
right=null;
}

}


public class BinaryTreeInorderSubsequence {

public void inorderTraversal(TreeNode root, List<Integer>inorder){

if(root==null)
return;

inorderTraversal(root.left, inorder);
inorder.add(root.val);
inorderTraversal(root.right,inorder);
}


public boolean isSortedInorderSubsequence(TreeNode root, int nums[]){

List<Integer>inorder = new ArrayList<>();
inorderTraversal(root,inorder);   // stores the inorder traversal
  
int i=0;

for(int num : inorder){

if(i<nums.length && num==nums[i]){  // here we are checking if nums array is a subsequence of  inorder traversal or not 
i++;
}

}

return i==nums.length;  // if i reached to the length of num, means we got the subsequence in inorder traversal

}



public static void main (String args[]){

TreeNode root = new TreeNode(0);
root.left = new TreeNode(1);
root.right = new TreeNode(2);
root.left.left = new TreeNode(3);
root.left.right = new TreeNode(4);

BinaryTreeInorderSubsequence treeSubsequence = new BinaryTreeInorderSubsequence();
int nums[]= {1,4,2};
int nums1[] = {3,1,0};
int nums2[] = { 3,4,1};
System.out.println(Arrays.toString(nums) +"->"+treeSubsequence.isSortedInorderSubsequence(root,nums));

System.out.println(Arrays.toString(nums1) +"->"+treeSubsequence.isSortedInorderSubsequence(root,nums1));

System.out.println(Arrays.toString(nums2) +"->"+treeSubsequence.isSortedInorderSubsequence(root,nums2));

} 
}




