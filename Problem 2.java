// ## Problem2 (https://leetcode.com/problems/coin-change-2/)

// Time Complexity : Optimized DP- O(MN), where M=number of coins, N=amount
// Space Complexity : Optimized DP- O(N), where N=amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    // 1. Exhaustive recursive solution
    private int count=0;
    private void helper(int[] coins, int amount, int idx){
        //base
        if(amount==0){
            count++;
            return;
        };
        if(idx==coins.length||amount<0)  return;  

        //logic
        //Case1 - choose current coin
        helper(coins, amount-coins[idx],idx);
        //Case2 - don't choose current coin
        helper(coins, amount,idx+1);
    }

    //2. Bottom-up dp of above exhaustive recursive approach
    int dp(int[] coins, int amount){
        int m=coins.length;
        int n=amount;

        int[][] storage=new int[m+1][n+1];
        // Base case
        // To make amount zero from empty array, there is one way
        storage[0][0]=1;

        // Rest of the first row will be zero, as there are no ways in which
        // we can make a non-zero amount from an empty coins array

        // Fill in the rest
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){
                    // Current amount is less than denomination, not choose case
                    // In this case we just take the sub problem at [i-1][j]
                    // that is make amount j, from array length upto (i-1)
                    storage[i][j]=storage[i-1][j];
                }else{
                    // Choose current denomination
                    int case1=storage[i][j-coins[i-1]];

                    // Do not choose current denomination
                    int case2=storage[i-1][j];

                    // Total ways
                    storage[i][j]=case1+case2;
                }
            }
        }
        return storage[m][n];
    }

    //3. Optimized dp for storage
    private int optimizedDp(int[] coins, int amount){
        int m=coins.length;
        int n=amount;
        int[] storage=new int[n+1];

        storage[0]=1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){
                    //Not choose case
                    storage[j]=storage[j];
                }else{
                    //Case1. choose
                    int case1=storage[j-coins[i-1]];
                    //Cae2. do not choose
                    int case2=storage[j];
                    storage[j]=case1+case2;
                }
            }
        }
        return storage[n];
    }

    public int change(int amount, int[] coins) {
        //1. Exhaustive recursive solution
        // helper(coins, amount, 0);
        // return count;

        //2. Bottom-up dp of above exhaustive recursive approach
        //return dp(coins, amount);

        //3. Optimized dp for storage
        return optimizedDp(coins, amount);
    }
}