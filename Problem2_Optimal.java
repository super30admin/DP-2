
/**
LeetCode Submission :
Space Complexity : O(N^2)
Time Complexity : O(N^2)
Use similar logic from previous problem once we enounter a solution i.e. amount = 0 add 1 to final possible solution
Instead of storing the minimum from previous step in DP array store the combinations available in the array
**/

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null)
            return 0;
        
        if(coins.length < 0)
            return 1;
        
        int [][] coins_count = new int[coins.length + 1][amount+1];
        int row  = coins.length + 1;
        int cols = amount + 1;
        
        coins_count[0][0] = 1;
        
        for(int i = 1; i<row; i++){
            for(int j = 0;j<cols; j++){
                if(i == 1){
                    coins_count[i][j] = 1;
                }
                
                if(j < coins[i-1]){
                    coins_count[i][j] = coins_count[i-1][j];
                }else{
                    coins_count[i][j] = coins_count[i-1][j] + coins_count[i][j - coins[i-1]];
                }
            }
            
        }
        
        return coins_count[row-1][cols-1];
        
        
        //return decision(amount,coins,0);
        
    }
    
    /*int decision(int amount, int[] coins, int i){
        if(amount == 0)
            return 1;
        
        if(amount < 0 || i >= coins.length)
            return 0;
        
        return decision(amount-coins[i],coins,i) + decision(amount,coins,i+1);
    }*/
    
}
