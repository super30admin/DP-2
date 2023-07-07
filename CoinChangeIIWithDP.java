// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
public class CoinChangeIIWithDP {

    public static int coinChanger(int amount, int[] coins) {

        if(coins == null || coins.length == 0) return 0;

        int m = coins.length;
        int n = amount;
        int[][] dpArr = new int[m+1][n+1];

        dpArr[0][0] = 1;

        for(int i=1; i<m+1; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(j < coins[i-1])
                {
                    dpArr[i][j] = dpArr[i-1][j];
                }
                else {
                    dpArr[i][j] = dpArr[i-1][j] + dpArr[i][j-coins[i-1]];
                }
            }
        }

       return dpArr[m][n];
    }

    public static void main(String args[])
    {
        int coins[] = {1,2,5};
        int amount = 5;
        System.out.println(coinChanger(amount, coins));
    }
}
