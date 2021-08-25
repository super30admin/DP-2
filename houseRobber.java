/*Running time Complexity: O(n)
Space Complexity: Constant space
Successfully Run and Compiled on leetcode
*/
class Solution {
    public int rob(int[] nums) {
        if(nums==null) return 0;
        
        int skip = 0; int take = nums[0];
        for(int i =1;i<nums.length;i++){
            int temp = skip;
            skip= Math.max(skip,take);
            take= nums[i]+temp;
        }
        return Math.max(skip,take);
    }
   
}