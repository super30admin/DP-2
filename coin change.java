// Time Complexity : O(mn)
// Space Complexity :O(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understood from the class


// Your code here along with comments explaining your approacclass Solution {
    public int change(int amount, int[] coins) {
        
    
     int n= coins.length+1;
        int m=amount+1;
        
        int[][] dp= new int[n][m];
        // fill up columns
        for(int j=1; j<m; j++)
        {dp[0][j]= 0; 
         }
        // fill up with rows
        for(int i=0;i<n;i++){dp[i][0]=1;}
        
        // filled 0th position go to 1st psition
        for(int i=1; i<n;i++){
            for(int j=1; j<m; j++){
                // coins[i-1] to access the coins
                if(j<coins[i-1]){dp[i][j]=dp[i-1][j];}
                // go that many steps behind and adding the total number of ways
                else{dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]] ;}
            }
        }
        // returning the number of ways
    return dp[n-1][m-1];
    }
    
}