
// Exhaustive approach - Fails at runtime because its exponential
public class PaintHouse_1 {
        // red - 0 blue - 1 green - 2
        public int minCost(int[][] costs) {
            if(costs==null || costs.length==0) return 0;
            int caseR = helper(costs,0,0,0);
            int caseB = helper(costs,0,1,0);
            int caseG = helper(costs,0,2,0);
            return Math.min(caseR, Math.min(caseB,caseG));
        }
        private int helper(int[][] costs, int idx, int color, int amount){
            // base
            if(idx == costs.length) return amount;
            
            // logic
            // red
            if(color==0){
                return Math.min(helper(costs, idx+1, 1, amount+costs[idx][0]), helper(costs, idx+1, 2, amount+costs[idx][0]));
            }
            
            // blue
            if(color==1){
                return Math.min(helper(costs, idx+1, 0, amount+costs[idx][1]), helper(costs, idx+1, 2, amount+costs[idx][1]));
            }
            
            // green
            if(color==2){
                return Math.min(helper(costs, idx+1, 0, amount+costs[idx][2]), helper(costs, idx+1, 1, amount+costs[idx][2]));
            }
            return 0;
        }
}

// Time Complexity - O(2 power n)
// Space Complexity - O(2 power n)

// DP Solution
public class PaintHouse_2 {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        // take the last row as it is
        for(int j=0;j<3;j++){
            dp[n-1][j] = costs[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            // red
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            // blue
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            // green
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
            
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

// Time Complexity - O(m+n)
// Space Complexity - O(n)

// DP Solution - No extra space used
public class PaintHouse_3 {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int n = costs.length;
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];
        
        for(int i=n-2;i>=0;i--){
            int tempR = costR;
            int tempB = costB;
            
            costR = costs[i][0] + Math.min(costB, costG);
            costB = costs[i][1] + Math.min(tempR, costG);
            costG = costs[i][2] + Math.min(tempR, tempB);   
        }
        return Math.min(costR, Math.min(costB, costG));
    }
}

// Time Complexity - O(m+n)
// Space Complexity - O(1)