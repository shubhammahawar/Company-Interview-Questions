class Solution {

   public void findCombination(int index, int[] candidates, int target, List<List<Integer>>ans, List<Integer>temp,int n)
 {
    if(target==0){
        ans.add(new ArrayList<>(temp));

     return;   
    }

    for(int i=index;i<n;i++){

        if(i>index && candidates[i]==candidates[i-1])
        continue;

        if(candidates[i]>target)
        break;

        temp.add(candidates[i]);
        findCombination(i+1,candidates,target-candidates[i],ans,temp,n);
        temp.remove(temp.size()-1);
    }
    

 }



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        int n = candidates.length;
        List<List<Integer>>ans = new ArrayList<>();
        findCombination(0,candidates,target,ans,new ArrayList<>(),n);
        return ans;

    }
}
