/*
This approach solves the problem using top-down recursive DP. We use a counter and a 
hash table, to count whenever an output with amount 0 is received, and we use a hash
table for storing whatever configuration of coins gave an amount 0, so that next time
if we encounter the configuration (which we will since the configuration will be repeated
in top-down recursive DP), we will not again increase the counter, as it has already been
set for that configuration.

Problems with this program: It run, but gives an incorrect answer

Did this code run on Leetcode: Yes

*/

import java.util.*;


class Solution {
    
    private int count=0;
    
    private Hashtable<Integer, Integer> ht = new Hashtable<>();
    
    //helper function to help with finding all the configurations
    private void helper(int amount, int[] coins, int coinIndex, int minCoins)
    {
        
         //if amount becomes less than 0 or index goes out of bounds we stop the recursion
        if(amount < 0 || coinIndex == coins.length)
            return;
        

        if(amount == 0)
        {  
            //We check if the configuration in the hash table already exists, if it doesn't 
            //then we add the configuration to the table and increase the count by 1
            if(ht.get(coins[coinIndex] + coinIndex + minCoins) == null)
            {
                ht.put(coins[coinIndex] + coinIndex + minCoins, 1);
                count++;
            }
                
            else
                return;
            
        }
       
        
        
        helper(amount - coins[coinIndex], coins, coinIndex, minCoins + 1);
        helper(amount, coins, coinIndex + 1, minCoins);
        
       
        
    }
        
     //Time complexity = O(3^n)
     //Space complexity = O(3^n)
    public int change(int amount, int[] coins) 
    {
        
        helper(amount, coins, 0, 0);
        
        return count;
        
    }
}