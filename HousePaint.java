// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        //using dp (using 3 variable)
        //null check
        if(costs == null || costs.length == 0) {
            return 0;
        }
        
        int lastRow = costs.length-1;
        int prevB = costs[lastRow][0];
        int prevG = costs[lastRow][1];
        int prevR = costs[lastRow][2];
        
       // choose blue, green , red house and then add cost of that house and min between other two adjacent houses
       for(int i = costs.length-2; i>=0 ;i--) {
        int tempB = prevB;
        int tempG = prevG;
        prevB = costs[i][0] + Math.min(prevR,prevG);
        prevG = costs[i][1] + Math.min(tempB,prevR);
        prevR = costs[i][2] + Math.min(tempB,tempG);
     }
        return Math.min(prevB, Math.min(prevG,prevR));
    }
}