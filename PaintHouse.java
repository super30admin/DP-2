// Time Complexity : O(n * c) where n is the number of houses and c being the number of colors. here c is fixed hence O(n) is tc
// Space Complexity : O(c) or O(1) since c is fixed here.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a prev array with length equal to num of colors put first row here since costs would be the same.
// For the following rows calculate the costs depending on current selection with min from previous calculated
// Finally return the min of the last entry or prev array.
class Solution {
    public int minCost(int[][] costs) {
        
        int[] prev = costs[0];
        for(int i = 1; i < costs.length; i++){
            int [] cur = new int[3];
            
            cur[0] = costs[i][0] + Math.min(prev[1], prev[2]);
            cur[1] = costs[i][1] + Math.min(prev[0], prev[2]);
            cur[2] = costs[i][2] + Math.min(prev[0], prev[1]);
            
            prev = cur;
        }
        return Math.min(prev[0], Math.min(prev[1],prev[2]));
}
}