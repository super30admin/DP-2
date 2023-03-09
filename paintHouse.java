/**
Time Complexity - O(N) where N is the size of the nums array.
Space Complexity - O(1)
 */
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
    
        int oldPrev = 0;
        int newPrev = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int temp = newPrev;
            newPrev = Math.max(newPrev, oldPrev + nums[i]);
            oldPrev = temp;
        }

        return newPrev;
    }
}
