//way1
//Exhaustive-- choose all the combinations. If the combinations is equals to target, add it to result
//TC: 2^(m+n)
class Solution {
    public int change(int amount, int[] coins) {
        return helper(amount,coins,0);
        
    }
    private int helper(int amount, int[] coins, int i){
        //base case
        if(amount==0) return 1;

        if(amount<0 || i==coins.length){
            return 0;
        }

        //logic
        //no choose
        int case1=helper(amount,coins,i+1);

        int case2=helper(amount-coins[i], coins, i);

        return case1+case2;
    }
}

//way2:
//Exhaustive-- choose all the combinations. If the combinations is equals to target, add it to result -- causing time limit exceeded
//Memoization-- remembering prev results and using them.
//TC: O(m*n); SC: O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo=new int[coins.length+1][amount+1];
        for(int i=0; i<=coins.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(amount,coins,0,memo);
        
    }
    private int helper(int amount, int[] coins, int i,int[][] memo){
        //base case
        if(amount==0) return 1;

        if(amount<0 || i==coins.length){
            return 0;
        }

        if(memo[i][amount]!=-1) return memo[i][amount];

        //logic
        //no choose
        int case1=helper(amount,coins,i+1,memo);

        int case2=helper(amount-coins[i], coins, i,memo);

        memo[i][amount]=case1+case2;

        return case1+case2;
    }
}

//way3:
//Tabulation
//Identify number of combinations for amount 0 to target with the given coins
//return the last element of dp array
//tc: o(m*n); sc:o(m*n)

class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int m=amount;

        int[][] dp=new int[n+1][m+1];

        dp[0][0]=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+(dp[i][j-coins[i-1]]);
                }
            }
        }

        return dp[n][m];
    }
}

//way4:
//Tabulation
//Identify number of combinations for amount 0 to target with the given coins
//return the last element of dp array
//tc: o(m*n); sc:o(n)

class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int m=amount;

        int[] dp=new int[m+1];

        dp[0]=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j<coins[i-1]){
                    dp[j]=dp[j];
                }else{
                    dp[j]=dp[j]+(dp[j-coins[i-1]]);
                }
            }
        }

        return dp[m];
    }
}

