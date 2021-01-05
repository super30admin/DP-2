/**
 * Time complexity - O(n)
 * Space complexity - O(1)
 * All test cases passed
 */
class Solution {
    public int minCost(int[][] costs) {
        //Using Dynamic Programming
        //Follow Bottom up approach
        //Not mutating the same array

        if(costs==null||costs.length==0)
            return 0;

        int tempr = costs[costs.length-1][0];
        int tempb = costs[costs.length-1][1];
        int tempg = costs[costs.length-1][2];

        for(int i=costs.length-2; i>=0; i--)
        {
            int temprt = tempr;
            tempr = costs[i][0]+Math.min(tempb,tempg);
            int tempbt = tempb;
            tempb = costs[i][1]+Math.min(temprt,tempg);
            tempg = costs[i][2]+Math.min(temprt,tempbt);
        }

        return Math.min(tempr,Math.min(tempb,tempg));
    }
}