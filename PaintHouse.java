// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        int housesLength = costs.length-1;
        int combination1 = costs[housesLength][0];
        int combination2 = costs[housesLength][1];
        int combination3 = costs[housesLength][2];
        for(int i=housesLength-1;i>=0;i--) {
            int temp1 = combination1;
            int temp2 = combination2;
            combination1 = costs[i][0] + Math.min(combination2, combination3);
            combination2 = costs[i][1] + Math.min(temp1, combination3);
            combination3 = costs[i][2] + Math.min(temp1, temp2);
        }
        return Math.min(combination1, Math.min(combination2, combination3));
    }
}

// Your code here along with comments explaining your approach
