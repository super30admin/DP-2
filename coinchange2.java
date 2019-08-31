//Time Complexity:O(N*n) where n is the amount.
//Space COmplexity:O(N*n) where n is the amount.
//In this problem, a new dp array is created for the length of amount+1. Then it is iterated for the whole array of coins and for less than or equal to amount and then at each iteration, different combinations are being computed. At the end the total number of combinations have been returned.
//This code was successfully executed and got accepted in leetcode.

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i:coins){
            for(int j=i;j<=amount;j++){
                dp[j]+=dp[j-i];
            }
        }
        return dp[amount];
    }
}