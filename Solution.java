// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : nopes


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs)
    {

        if(costs==null||costs.length==0)
            return 0;

        int n=costs.length;
        int cR=0;
        int cB=0;
        int cG=0;

        for(int i=0;i<n;i++)
        {
            int tempR=cR;
            int tempB=cB;

            cR=costs[i][0]+Math.min(cB,cG);
            cB=costs[i][1]+Math.min(tempR,cG);
            cG=costs[i][2]+Math.min(tempR,tempB);
        }

        return Math.min(cR,Math.min(cB,cG));

    }
}