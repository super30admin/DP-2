//Problem 1
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)


class Solution1 {
    public int change(int amount, int[] coins) {
        int n = coins.length+1;
        int m = amount +1;
        int dp[][] = new int[n][m];
        
        //1st coloumn = 1
        for(int i = 0; i<n ; i++){
            dp[i][0] = 1;
        }
        
        //1st row = 0
        for(int j = 1; j<m ; j++){
            dp[0][j] = 0;
        }
        //rest of the matrix
        for(int i = 1; i<n ; i++){
            for(int j = 1; j<m ; j++){
                
                //if amount is less than biggest coin
                if(j < coins[i-1]){
                    //the same answer as 1 row up
                    dp[i][j] = dp[i-1][j];
                }
                
                else{
                    //else add the answer from 1 row up with the answer from biggest coin - 1 
                    //coloumns back
                    dp[i][j] = dp[i-1][j] +dp[i][j - coins[i-1]];
                }
            }
            
        }
        return dp[n-1][m-1];
    }
}


//Problem 2
// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution2 {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null || costs[0].length == 0){
            return 0;
        }
        int n = costs.length;
        for(int i = 1; i< n; i++){
            
            // min for red
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            
            //min for green
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            
            //min for blue
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        //find min among red, green, blue in the last row
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }
}
