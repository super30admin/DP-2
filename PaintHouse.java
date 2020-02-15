/*
Recursive Approach
// Time Complexity : 2^n
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode :Yes
// Your code here along with comments explaining your approach
if we have robbed one house we can not rob adjancent house. at every house We would be making decision that whether to rob house or not. If we rob the house we would then we recursively exploring house next to the adjancent house(index+2) and if we dont choose we would  recursively explore from adjancent house
*/

class Solution {
    public int rob(int[] nums) {
        return robUtil(nums, 0, 0);
    }
    public int robUtil(int[]nums, int index, int max){
        //base case
        if(index >= nums.length)
            return max;
        //choose the house
        int case1 = robUtil(nums, index+2 , max+nums[index]);
        // dont choose the house
        int case2 = robUtil(nums, index+1, max);
        return Math.max(case1, case2);
    }
}
/*      [1,2,3,1,6] 
[3,1,6]        [2,3,1,6]    
[6] [1,6]     [3,1,6] [1,6]

Repeated sub problems
*/


/*
DP Approach
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Your code here along with comments explaining your approach

*/

class Solution {
    public int rob(int[] nums) {
        return robUtil(nums, 0, 0);
    }
    public int robUtil(int[]nums, int index, int max){
        //base case
        if(index >= nums.length)
            return max;
        //choose the house
        int case1 = robUtil(nums, index+2 , max+nums[index]);
        // dont choose the house
        int case2 = robUtil(nums, index+1, max);
        return Math.max(case1, case2);
    }
}

