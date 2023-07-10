// Time Complexity : O(n*m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Here we have to calculate the number of ways an amount can be made. 
//So here we have taken a dp array of the size of the amount, checked how many coins have been needed to make the amount using the previous coin and adding that to the no. of current coins used for the same amount

// Using 1D Array

class Solution {
    public int change(int amount, int[] coins) {
  int n=coins.length;
  int m=amount;
int [] dp=new int[m+1];
dp[0]=1;
 for(int i=1;i<=n;i++)
 {
     for(int j=0;j<=m;j++)
     {
         if(j<coins[i-1])
         {
             dp[j]=dp[j];
         }
        else
        {
//dp[j] here is the amount of the previous row + (amount-the coin)            
            dp[j]=dp[j]+dp[j-coins[i-1]];
        }
       
     }
 }
        return dp[m];
    }
}




/* 
Exhaustive approach


//In this we have to count the number of paths and not the path which uses the minimum number of coins
 
 class Solution {
    public int change(int amount, int[] coins) {
       if (coins==null) return 0;
       return helper(coins, 0, amount);
    }
    public int helper(int[] coins, int i,int amount)
    {
        //base
        if(amount==0) return 1;
        if(amount<0 || i==coins.length) return 0;
       //not choose
//This is the side where we don't choose the element at 'I' and we choose the element next to it

        int case0=helper(coins,i+1,amount);
         //choose 
//This is the side where we choose the element at 'I' and we deduct its value from the amount

        int case1=helper(coins,i,amount-coins[i]);
        
        return case0+case1;
    }
}


DP: Using 2D Matrix

 //In this we have to count the number of paths and not the path which uses the minimum number of coins
 
 class Solution {
    public int change(int amount, int[] coins) {
  int n=coins.length;
  int m=amount;
int [][] dp=new int[n+1][m+1];
dp[0][0]=1;
 for(int i=1;i<=n;i++)
 {
     for(int j=0;j<=m;j++)
     {
         if(j<coins[i-1])
         {
             dp[i][j]=dp[i-1][j];
         }
        else
        {
            dp[i][j]=dp[i-1][j]+ dp[i][j-coins[i-1]];
        }
       
     }
 }
        return dp[n][m];
    }
}

*/