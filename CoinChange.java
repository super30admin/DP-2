class Solution {
    public int change(int amount, int[] coins) {
        if(coins== null) return 0;
        int[] dp= new int[amount+1];
        int index=0;
        dp[0]=1;
        for(int i=1 ;i< dp.length; i++){
            dp[i]=0;
        }
      // logic
        for(int j=0; j<coins.length; j++){
            //System.out.println("Considering coin"+coins[j]);
            for(int i=1; i<=amount; i++){
                int k=(i-coins[j]>=0)? dp[i-coins[j]]:0;
                if(k>0)  dp[i]= dp[i]+k;
              
            }
         //    for(int i=0; i<dp.length; i++){
         //         System.out.print(dp[i] + "   ");
         // }
            //System.out.println();
        }
         
        return dp[amount];
       
    }
  
}

// Time complexity- O(n*amount)
// space complexity- O(amount)

//memoziation

class Solution {
    
   
    private int helper(int amount, int[] coins, int coinIndex, Integer[][] dp) {
     
        if(amount<0 || coinIndex<0)
            return 0;
        if(amount==0)
            return 1;
        
        if(dp[amount][coinIndex]!=null)
            return dp[amount][coinIndex];
        
      //  System.out.println("Amount:" + amount + " coinIndex:" + coinIndex);
        int notUsing = helper(amount, coins, coinIndex-1,dp); //not using it
        int using = helper(amount-coins[coinIndex], coins, coinIndex,dp); //using it
     
     //  System.out.println("Using:"+ using + " Not using:"+notUsing);
        dp[amount][coinIndex] = using + notUsing;
        return dp[amount][coinIndex];
        
        
    }

    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[amount+1][coins.length];
        
       return helper(amount, coins, coins.length-1, dp);
    }
    
}
// Time complexity- O(n* amount)
// Space complexity- O(amount* n)