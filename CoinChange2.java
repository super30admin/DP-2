/**

    Leetcode Problem 518: Coin Change 2
    
    You are given coins of different denominations and a total amount of money. Write a function to 
    compute the number of combinations that make up that amount. You may assume that you have 
    infinite number of each kind of coin.
    
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Brute Force Algorithm:

    private int coinChangeHelper(int coins[], int amount, int index)
    {
        if(amount == 0) 
            return 1;
        
        if(amount < 0 || index >= coins.length ) 
            return 0;
        
        // we choose the coin
        int case1 = coinChangeHelper(coins, amount -coins[index], index);
        
        // we donot choose the coin
        int case2 = coinChangeHelper(coins, amount , index+1);
        
        
        return case1 + case2;
    
    }
    
Time Complexity : O(M*N)
Space Complexity : O(M*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Collabedit: http://collabedit.com/a7vwq
**/

class Solution 
{
    public int change(int amount, int[] coins) 
    {
        if(coins == null)
            return 0;
            
        return coinChangeHelper(coins, amount, 0);
    }
    
    private int coinChangeHelper(int coins[], int amount, int index)
    {
        
        if( coins == null)
            return 0;
        
        if(coins.length == 0 && amount == 0) 
            return 1;
        
        int matrix[][] = new int[coins.length + 1][amount+1];
        
        for( int i=1; i< matrix.length; i++)  
            matrix[i][0] = 1;
        
        for( int i=1; i< matrix.length; i++)    
        {
            for(int j=1; j<matrix[0].length; j++)
            {
                
                if( j < coins[i-1]) {
                    matrix[i][j] = matrix[i-1][j];
                }
                else
                {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i-1]];
                }
            }
        }
        
        
        return matrix[matrix.length-1][matrix[0].length -1];
    
    }
}