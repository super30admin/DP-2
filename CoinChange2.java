// Time Complexity : exponential
// Space Complexity : exponential
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach



//revurisve solution

class Solution {
    public int change(int amount, int[] coins) {
        
        return helper(coins,amount,0);
    }
    
    private int helper(int coins[], int amount ,int index){
        
        //base
        if(amount == 0 )
            return 1;
        
        if(amount < 0 || index == coins.length)
          return 0;
      
        
        //logic
        int case1 =  helper(coins,amount,index+1);
         //  choose a coin
        int case2 =  helper(coins, amount - coins[index],index);
        // not choose a 
      
        return case1+case2; 
    }
}










// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

//dp solution

class Solution {
    public int change(int amount, int[] coins) {
     
        
        int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i = 0 ; i < dp.length ; i++)
        {
            dp[i][0] = 1;
        }
        
        
        for( int i = 1; i < dp.length;i++){
            
            for( int j = 1; j < dp[0].length; j++){
                
                if( j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                
                
            }
        }
        
        return dp[coins.length][amount];
    }
   
}

