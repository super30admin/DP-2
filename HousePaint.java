// Time Complexity :o(m*n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int R = costs[0][0]; int B = costs[0][1]; int G = costs[0][2];//first row assigning to variables
        for(int i = 1; i < n; i++){
            int tempR = R; int tempB = B; // keeping in temp coz, value changes, and being used in next steps
            R = costs[i][0] + Math.min(B, G);//take min of  b and g, since in previous step u cannot take r
            B = costs[i][1] + Math.min(tempR,G);
            G = costs[i][2] + Math.min(tempR,tempB);
        }
        return Math.min(R,Math.min(B, G));//take min cost of the 3, as it gives min cost
    }
    
}