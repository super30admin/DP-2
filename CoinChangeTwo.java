
// Time Complexity :O(N^2)
// Space Complexity :O(N^2)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class CoinChangeTwo {
     public int change(int amount, int[] coins) {
         if(coins.length==0 || coins==null){
             return 0;
         }
         int dp[][]=new int[coins.length+1][amount+1];
         for(int i=0;i<coins.length;i++){
             dp[i][0]=1;
         }
         for(int i=1;i<coins.length+1;i++){
             for(int j=1;j<amount+1;j++){
                 if(j<coins[i-1]){
                     dp[i][j]=dp[i-1][j];
                 }
                 else{
                     dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                 }
             }
         }
        return dp[coins.length][amount];
    }
    public static void main(String args[]){
        CoinChangeTwo obj=new CoinChangeTwo();
        int amount=11;
        int coins[]={1,2,5};
        System.out.println(obj.change(amount, coins));
    }
}
