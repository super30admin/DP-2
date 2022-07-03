//Facebook Interview
//Time Complexity = O(mn)
//Space Complexity = O(n)
//Search for all combinations using exhaustive method should not miss any combination.Whether it is sorted or not it doesnot effect 
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        
        int m = coins.length;//row 
        int n = amount;//column
        //incrementing row and columns and storing in dp
        int [][] dp = new int[m+1][n+1];
        
         //columns are filled with zero and rows are checking to n-1 and its value is '1'//pick coin 'o' so it marked in amount '1'.
        for(int i=0;i<m+1;i++){
            dp[i][0] = 1;
        }
        
        //because in array 'i' as incremented by '1' but becuase in the original array there is the normal size as it is in the array.
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j < coins[i-1]){
                    //only zero case is available
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        //return 2d matrix stored array
        return dp[m][n];  
    }
}