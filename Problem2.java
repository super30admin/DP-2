//time - O(mn)
//space - O(mn)

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for(int i=1;i<=amount;i++) {
            dp[0][i] = 0;
        }
        
        for(int i=1; i<=coins.length; i++) {
            for(int j=0; j<=amount; j++) {
                if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
           for(int i=0; i<=coins.length; i++) {
            for(int j=0; j<=amount; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        
        return dp[coins.length][amount];
    }
}

//recursion
class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length+1][3];
        
        for(int i=1; i<=costs.length; i++) {
            dp[i][0] = costs[i-1][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = costs[i-1][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = costs[i-1][2] + Math.min(dp[i-1][1],dp[i-1][0]);
            System.out.println( dp[i][0] + " " +  dp[i][1] + " " +  dp[i][2]);
        }
        return Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1], dp[dp.length-1][2]));
        
    }
}