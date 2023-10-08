// here we want the number of ways we can get to amount 
// so in the 2d matrix we will have amount and number of ways we can get that amount with that coin
//       0 1 2 3 4 5 6 7 8 9 10 11
//     0 1 1 1 1 1 1 1 1 1 1 1 1 1 
//     1 1 1 1 1 1 1 1 1 1 1 1 1 1 (using coin 1 we have only one way to make the amount above )
//     2 1 1 2 2 3 3 4 4 5 5 6 6 7 (in column 1 and row 2 we can make amount 2 with 1 coin of 2 and 2 coins of 1)
//     5 1 1 2 2 3 4 5 6 7 7 9 10 13

// take the amount from above and add the amount by walking the number of coin denoiminations back 
// dp[i-1][j] + dp[i][j - coints[i-1]]

// space optimization will be to replace the previous row with new values because that is what we are using next

//Time complexity : O(mxn)
//Space complexity: 0(n)
//works on leetcode

public class CoinChangeSecond {
    public static void main(String[] args)
    {

        int[] coins = {1,2,5};
        int target = 11;
        System.out.println("Number of ways forming the amount" + target + " is " + numberOfCoins(coins,target));
    
    }

    public static int numberOfCoins(int[] coins, int target)
    {
        int m = coins.length;
        int n = target;
        int []dp = new int[n+1];
        dp[0] = 1; 

        for(int i = 1; i <=m; i++)
        {
            for(int j = 1; j<=n; j++) // j is column
            { 

            
            if(j < coins[i-1])
            {
                dp[j] = dp[j];
            }
            else
            {
                dp[j] = dp[j] + dp[j- coins[i-1]];
            }

        }}

        return dp[n];

    }
}
