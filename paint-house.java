// Time Complexity - O (N * 3)
// Space Complexity - O (1)

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        
        for(int i=1; i<n;i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);                 
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);                    
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }    
}
 
// class Solution {
//     public int minCost(int[][] costs) {
//         if(costs == null || costs.length == 0) {
//             return 0;
//         }
        
//         int case1 = helper(costs, 0, 0, 0);
//         int case2 = helper(costs, 0, 1, 0);
//         int case3 = helper(costs, 0, 2, 0);
        
//         return Math.min(case1, Math.min(case2, case3));
//     }
    
//     public int helper(int[][] costs, int row, int color, int min) {
        
//         if(row==costs.length) {
//             return min;
//         }
        
//         int case1 = Integer.MAX_VALUE;
//         int case2 = Integer.MAX_VALUE;
//         int case3 = Integer.MAX_VALUE;
        
//         if(color == 0) {
//             case2 = helper(costs, row + 1, 1, costs[row][1] + min);
//             case3 = helper(costs, row + 1, 2, costs[row][2] + min);            
//         }
//         if(color == 1) {
//             case1 = helper(costs, row + 1, 0, costs[row][0] + min);
//             case3 = helper(costs, row + 1, 2, costs[row][2] + min);            
//         }
//         if(color == 2) {
//             case1 = helper(costs, row + 1, 0, costs[row][0] + min);
//             case2 = helper(costs, row + 1, 1, costs[row][1] + min);            
//         }
        
//         return Math.min(case1, Math.min(case2, case3));
//     } 
// }
