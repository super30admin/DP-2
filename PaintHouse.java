// Time Complexity : O(2^ N) - no of houses
// Space Complexity : O(M*N) - No of houses * cost[i] 
// Did this code successfully run on Leetcode :No, TLE
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        // int case0 = helper(costs, 0, 0, 0);
        // int case1 = helper(costs, 0, 1, 0);
        // int case2 = helper(costs, 0, 2, 0);
        // return Math.min(case0, Math.min(case1,case2));
        int n = costs.length;
        for(int i=1;i<n;i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1],costs[n-1][2]));
    }
//     private int helper(int[][] costs, int row, int lastcolor, int sum){
//         //base
//         if(row == costs.length)
//             return sum;
        
//         int case0 = Integer.MAX_VALUE;
//         int case1 = Integer.MAX_VALUE;
//         int case2 = Integer.MAX_VALUE;
//         //logic
//         if(lastcolor == 0) {
//             case1 = helper(costs, row + 1, 1, sum + costs[row][1]);
//             case2 = helper(costs, row + 1, 2, sum + costs[row][2]);
//         }
//         if(lastcolor == 1) {
//             case0 = helper(costs, row + 1, 0, sum + costs[row][0]);
//             case2 = helper(costs, row + 1, 2, sum + costs[row][2]);
//         }
//         if(lastcolor == 2) {
//             case0 = helper(costs, row + 1, 0, sum + costs[row][0]);
//             case1 = helper(costs, row + 1, 1, sum + costs[row][1]);
//         }
//         return Math.min(case0, Math.min(case1,case2));
//     }
}