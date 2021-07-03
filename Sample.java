// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        int count = 0;
        
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <=amount; j ++) {
                
                if(amount == 0) {
                    count++;
                }
                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}


// Time Complexity : O(m+n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
//         if(costs == null || costs.length == 0) {
//             return 0;
//         }
        
//         for(int i = costs.length - 2; i >= 0 ; i--) {
//              costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
//              costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2]);
//              costs[i][2] += Math.min(costs[i+1][0],costs[i+1][1]);
//         }
//         return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
        
        
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int[] tracker = new int[3];
        
        for(int i = costs.length - 1; i >= 0; i--) {
            
            if(i == costs.length - 1) {
                tracker[0] = costs[i][0];
                tracker[1] = costs[i][1];
                tracker[2] = costs[i][2];
            } else {
                int temp0 = tracker[0];
                int temp1 = tracker[1];
                int temp2 = tracker[2];
                tracker[0] = costs[i][0] + Math.min(temp1,temp2);
                tracker[1] = costs[i][1] + Math.min(temp0,temp2);
                tracker[2] = costs[i][2] + Math.min(temp0,temp1);
            }    
        }
        System.out.println(Arrays.deepToString(costs));
        return Math.min(tracker[0], Math.min(tracker[1],tracker[2]));
    }
}