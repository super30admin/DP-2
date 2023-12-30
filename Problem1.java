//Accepted on Leetcode
//The idea was to make a matrix and keep the track for min profit while filling the matrix
//Time should be O(mxn) where mn is size of matrix

class Solution {
    public int minCost(int[][] costs) {
        int n =costs.length;
        int c = costs[0].length;
        int[][] dp = new int[n][c];
        int min = Integer.MAX_VALUE;

        for(int i =0;i<n;i++){
            for(int j=0;j<c;j++){
                if(i==0){
                    dp[i][j] = costs[i][j];
                }
                else{
                    if(j==0){
                        dp[i][j] = Math.min(costs[i][j] + dp[i-1][j+1],costs[i][j] + dp[i-1][j+2]);
                    }
                    if(j==1){
                        dp[i][j] = Math.min(costs[i][j] + dp[i-1][j-1],costs[i][j] + dp[i-1][j+1]);
                    }
                    if(j==2){
                        dp[i][j] = Math.min(costs[i][j] + dp[i-1][j-1],costs[i][j] + dp[i-1][j-2]);
                    }
                    
                }
                if(i==n-1){
                    if(min>dp[i][j]){
                        min = dp[i][j];
                    }
                }

            }

        }


        return min;
        
    }
}