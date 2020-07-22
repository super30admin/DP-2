//Time complexity=O(N*M), M=amount, N=no. of coins
//Space complexity=O(M), M=amount
//Here we can do the solution using an array of size amount instead of the matrix of M*N, the method is same as before. Just the space complexity is reduced.

class Solution {
    public int change(int amount, int[] coins) {
        //base case
        if(coins.length==0 && amount==0)
            return 1;
        
        int[] dp=new int[amount+1];
        dp[0]=1;
        int j=0;
        while(j<coins.length){
        for(int i=1;i<=amount;i++)
        {
            if(i>=coins[j])
                dp[i]=dp[i]+dp[i-coins[j]];
        }
            j++;
        }
        return dp[amount];
	}
}