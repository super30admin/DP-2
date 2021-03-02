// Time Complexity : O(n*(k^2)) -> where 'n' is the number of houses and k is the number of colors
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : This is code is generalized for more than 3 colors. Initially I was finding it difficult to come up with the more generalized approach, 
// I tried with different approaches and finally I was able to find the solution with a time complexity mentioned here. I am still trying to improvise my code to reduce to O(n*k). 


// Your code here along with comments explaining your approach
/* 
 * The idea was to find an optimal path for all the houses to be painted with minimum cost, where no adjancent houses are painted the same color. 
 * The approach initially was to choose each house with a color and check the minimum cost on each level, the time complexity would be O(2^n).
 * So, started with the 2nd house and chose each value where in the adjacent house previous & next to the current house would be of a minimum cost.  
 * This approach would require O(n) time complexity, 
 * */
class Solution{
	
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        
        int row = costs.length;
        int col = costs[0].length;
        
        //considerin from the 2nd row, trying to find the optimal solution at each level
        for(int i=1;i<costs.length;i++){
            for(int j=0;j<col;j++){
                costs[i][j] += findMin(costs,i-1,j);                
            }
        }
        
        int finalMinValue = Integer.MAX_VALUE;
        //Final result is present inside the last row. Need to find the minimum in that.
        for(int x:costs[row-1]){
            finalMinValue = Math.min(x,finalMinValue);
        }
        
        return finalMinValue;
        
        
    }
    
    public int findMin(int[][] costs,int i,int j){
        int minVal = Integer.MAX_VALUE;
        for(int col = 0;col<costs[0].length;col++){
            if(col==j)
                continue;
            minVal = Math.min(minVal,costs[i][col]);
                
        }
        return minVal;
    }
    
 // Time Complexity : O(m*n) where m and n are the rows and columns of the dp array.
 // Space Complexity : O(m*n)
 // Did this code successfully run on Leetcode : yes
    
 //Approach
    /*
     * Coin change 2 problem requires us to find the number of ways to reach the total amount.
     * I was able to identity overlapping subproblem, where each coin is either selected or not selected eventually branching out to a leading overlapping subproblem.
     * The optimal substructure which I found was - the number of ways to reach the amount and summing up with both selected and not selected.
     * */
    
    public int change(int amount, int[] coins) {
        int n = coins.length+1;
        int m = amount+1;
        
        int[][] dp = new int[n][m];
        
        //making the first row 0 as there are '0' ways to reach to the amount keeping 0 coins
        for(int j=1;j<m;j++)
            dp[0][j] = 0;
        
        //making the first row as 1 as there is only 1 way to reach the amount 0, i.e by not selecting anything
        for(int i=0;i<n;i++)
            dp[i][0] = 1;

        //the logic to fill the dp array and sum the chosen and not chosen parts
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j-coins[i-1]>=0){
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}