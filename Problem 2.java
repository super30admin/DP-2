```
//Crate a matrix which has amount+1 column and no. of coins +1 rows.
//The main idea is to populate the matrix with ways to achieve jth amount with (0 to ith rows of coins) 
//Initially we popuate first row with all zero as we have 0 ways to achieve amouunt >0 with 0 denomination //coin(dummy coin ,first row)
//First column with all 1 as there is 1 way to make amount 0 with any denomination coin.
//To fill the rest of the matrix we check if iterator j is less than denomination of coin we are at , we know it will be only one way to achieve that amuount
//Else we can either go with ith denomination coin(achieved by subtracting) + (ith-1) denomination
class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length+1;
        int n= amount+1;
        int[][]dp= new int[m][n];
        
         for(int j=1;j<n;j++)
            dp[0][j]= 0;
                
        for(int i=0;i<m;i++)
                dp[i][0]=1;
      
        
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                  dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        
        return dp[m-1][n-1];

    }
}

```
Time complexity- O( amount * coins.length) ,Space complexity-O( amount * coins.length)

Solution 2-
```
//In the previous solution we can notice that we only require i-1 row to calculate the net row , so instead of creating new matrix. We can store the previous values in one single matrix and update it for current denomination of coin we are at.
//It decreases the space complexity , though the time complexity is the same.
class Solution {
    public int change(int amount, int[] coins) {
        int dp[]= new int[amount+1];
        int n=amount+1;
        dp[0]=1;//amount =0 with 0 denomination coin(dummy coin).
        for(int i=1;i<n;i++)
            dp[i]=0;
        for(int i=0;i<coins.length;i++)
        {
            for(int j=coins[i];j<n;j++)
            {
                dp[j]+= dp[j-coins[i]];
            }
        }
        return dp[n-1];
    }
}
```
 , Time complexity- O( amount * coins.length),Space complexity-O(amount)