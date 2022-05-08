// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int costsR = costs[n-1][0];
        int costsB = costs[n-1][1];
        int costsG = costs[n-1][2];
        for(int i = n-2; i >= 0; i--) {
            int tempR = costsR;
            int tempB = costsB;
            costsR = costs[i][0] + Math.min(costsB, costsG);
            costsB = costs[i][1] + Math.min(tempR, costsG);
            costsG = costs[i][2] + Math.min(tempB, tempR);
        }
        return Math.min(costsR, Math.min(costsB, costsG));
    }
}