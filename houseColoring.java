// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


public class houseColoring {
        public int minCost(int[][] costs) {
            int n = costs.length;
            int[][] dp = new int[n+1][n+1];
            if(n==1){
                return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
            }
            for (int j=0; j<3; j++){
                dp[n-1][j] = costs[n-1][j];
            }
            for(int i = n-2 ; i>= 0 ; i--){
                
                        dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
                    
                        dp[i][1] = costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
                    
                        dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
                    
                
            }
            
            int min = Integer.MAX_VALUE;
            for( int k = 0; k<3; k++){
                min = Math.min(min, dp[0][k]);
            }
            return min;
        }
    }

