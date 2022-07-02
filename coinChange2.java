// Time Complexity :O(n*m) where n is number of coins and m is amount
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public int change(int amount, int[] coins) {
    if(coins == null || coins.length ==0){
        return 0;
    }
    // row for the dp array
    int m = coins.length;
    //column for the dp array
    int n = amount;
    
    int[][] dp = new int[m+1][n+1];
    
    for(int i=1;i<m+1;i++){ // for filling the first column of the matrix
        dp[i][0]=1;
    }
    // iterating thru the matrix
    for(int i=1;i<m+1;i++){
        for(int j=1;j<n+1;j++){
            if(j < coins[i-1]){ // if the amount is less than the coin denomination then add the possible combination from top
                dp[i][j] = dp[i-1][j];
            }else { // if the amount is greater than the coin denomination then add possible comibation from side and top
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
    }
    // return the output stored in the last row and column
    return dp[m][n];