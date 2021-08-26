// Time Complexity : O(m x n) where m is coin denominations and n is amount
// Space Complexity : O(m x n) where m is coin denominations and n is amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange2 {
    public int change(int amount, int[] coins) {
        //null check
        if(coins == null || coins.length == 0) return 0;
        
        //declaring dp array
        int[][] dp = new int[coins.length+1][amount+1];
        //rows=coins denominations (because 0) | columns=amount + 1 (because $0)
        
        //filling up the first column 
        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 1; //because there one way to make 0 dollars in first column
        }
        
        //rest of the columns
        for(int i=1; i<dp.length; i++) { //starting from 1 because 0th column filled
            for(int j=1; j<dp[0].length; j++) { //for rows
                if(j < coins[i-1]) { 
                    //till the time col number is not reached the denomination value
                    dp[i][j] = dp[i-1][j];
                    //it just stores the value of prev row value
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; 
                    //adds the value stored in dp
                    //which is back by index equal to coin denomination
                    //e.g. if $2 coin, go back in the same row
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
        //last row and low col value will have the total number of combinations
    }
}
