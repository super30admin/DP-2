// Time Complexity : O(m*n) n- No of coins (len of array), m- amount 
// Space Complexity :O(m*n) 

class Solution {
    public int coinChange(int amount, int[] coins) {
        int[][] dp;
        int c=amount+1;
        int r=coins.length+1;
        dp=new int[r][c];
        
        for(int i=0;i<r;i++){
            //intialize the first col with 1 because the no of ways to form anount 0 with any coin is 
            //1 that is by not chosing that coin
            dp[i][0]= 1; 
        }
        
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(j<coins[i-1]){
                    //if the current amount is less than coin we can get the ans from above row
                    dp[i][j]= dp[i-1][j] ;
                }else{
                    //the ans is addition of the 0 case that is form above row and the 1 case that is 
                    //current amount - current coin 
                    dp[i][j]= dp[i-1][j]  + dp[i][j-coins[i-1]];    
                }
                
            }
        }
        
        return dp[r-1][c-1];
    }
}