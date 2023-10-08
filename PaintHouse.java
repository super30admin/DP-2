// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class PaintHouse {
    class Solution{
        public int minCost(int[][] costs){
            int n = costs.length;
            int dpRed = costs[n-1][0];
            int dpGreen = costs[n-1][1];
            int dpBlue = costs[n-1][2];

            for(int i = n-2; i >= 0; i--){
                int temp1= dpRed;
                dpRed = costs[i][0] + Math.min(dpGreen, dpBlue);
                int temp2 = dpGreen;
                dpGreen = costs[i][1] + Math.min(temp1, dpBlue);
                dpBlue = costs[i][2] + Math.min(temp1, temp2);
            }
            return Math.min(dpRed, Math.min(dpGreen, dpBlue));
        }
    }
}
