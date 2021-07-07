//time - O(mn) - m -> amount and n -> coin array length
//space - O(mn) - m -> amount and n -> coin array length
class Solution {
    public int change(int amount, int[] coins) {
        //2 constarints - so using a dp matrix
        int n = coins.length + 1;
        int m = amount + 1;
        int[][] result = new int[n][m];
        
        result[0][0] = 1; // 1 way to make a 0 amount with no coins
        //with no coins number of ways to make a +ve amount is 0 - other cells in first row
        
        //with 0 amount number of ways is 1 for any coins[] i.e. dont pick the coin
        for(int i = 1; i < n; i++)
        {
            result[i][0] = 1;
        }
        
        for(int i = 1; i < n ; i++)
        {
            for(int j = 1; j < m; j++)
            {
                int currentCoin = coins[i - 1];
                if(currentCoin > j)
                {
                    result[i][j] = result[i - 1][j]; //dont choose the coin and pull from top
                }
                else
                {
                    int choose = result[i][j - currentCoin];
                    int dontChoose = result[i - 1][j];
                    result[i][j] = choose + dontChoose; // number of ways is sum of both options
                }
            }
        }
        return result[n - 1][m - 1];        
    }
}
