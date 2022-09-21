// TC - O(length of coins array * amount)
// SC - O(length of coins array * amount)

class Solution {
    public int change(int amount, int[] coins) {
        
        
        int[][] memo = new int[coins.length][amount+1];
        
        for(int i = 0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        int ans = minCoins(coins,amount,0,memo);
        if(ans==0) return 0;
        return ans;
    }
    
    public int minCoins(int[]coins,int amt,int currIndex,int[][]memo){
        
        if(amt==0) return 1;
        
        if(currIndex>=coins.length) return 0;
        
        if(memo[currIndex][amt]!=-1) return memo[currIndex][amt];
        
        int Consider = 0;
        
        if(amt>=coins[currIndex]){
            Consider = minCoins(coins,amt-coins[currIndex],currIndex,memo);
        }
        int notConsider =  minCoins(coins,amt,currIndex+1,memo);
        
        memo[currIndex][amt] =Consider + notConsider;
        
        return memo[currIndex][amt];
    }
    
}