/*Time Complexity: O(m*n).m is the number of rows and n is number of columns
Space Complexity : O(m*n)
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null){
            return -1;
        }
        //declare the 2d array with coins.length rows and amount cols
        int dp[][] = new int[coins.length+1][amount+1];//+1 is added as the last value is also taken into consideration
        //initialize the first col with 1's as  0 coins cannot be used to get the total amount
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        //declare the 2d array with coins.length rows and amount cols
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //check if the coin value is grater than the amount if so set to max value
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                //otherwise calculate the amount value 
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}