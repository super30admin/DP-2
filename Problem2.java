// Brute Force
//Time Complexity - 2^n
//Space Complexity - 2^n
//This code did not work on Leetcode

class Solution {
    public int change(int amount, int[] coins) {
        return(helper(coins,0,amount));
    }
    private int helper(int[] coins,int i,int amount){
        //Base Case
        if(amount ==0)  return 1;     //if amount is reached 0 add 1 to the ways amount can be calculated using that combination path
        if(amount <0 || i>=coins.length)    return 0; //if amount reaches less than 0 or i reaches the end of the coins array that means the amount cannot be calculated using this combiation path, hence return 0 which means no way found
        //logic
         int Case1=0,Case2=0;
           Case1 += helper(coins,i,amount-coins[i]);   //choose
           Case2 += helper(coins,i+1,amount);  //not choose 
        return Case1+Case2;
    }
}


// Dynamic Programing
// Time Complexity : O(S*n)  -- where S is the amount and n is the number of denominations
// Space Complexity : O(S*n) -- LeetCode shows it O(n) why?
// This code worked on LeetCode

class Solution {
    public int change(int amount, int[] coins) {
        int m = amount;
        int n = coins.length;
        int[][] dp = new int[n+1][m+1];  //java initializes with 0s by default after creating dp array
        dp[0][0] =1;  //initialize the number of ways 0 can be created using 0 denomination as 1
        for(int i=1;i<=n;i++){
            dp[i][0]=1;
            for(int j=1;j<=m;j++){
                if(j<coins[i-1])  
                    dp[i][j] = dp[i-1][j];   //copy the value from above row if the column index is less than the denomination
                else 
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];  //copy the value from above row and add the value of coins[i] steps before
            }
        }
        return dp[n][m];  // return the last calulated value
    }
}

