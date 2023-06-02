// Time Complexity : O(m*n) where 'm' is number of coins and 'n' is the target amount
// Space Complexity : O(m*n) where m is number of coins and n is the target amount

class Solution
{
    private int target;
    private int[][] dpArray;
    public int change(int amount, int[] coins)
    {
        this.target = amount;
        if(coins == null) return 0;

        //initialize the dpArray
        dpArray = new int[coins.length+1][target+1];
        return getNumberOfCoins(coins, coins.length, target);

    }
    private int getNumberOfCoins(int[] coins, int index, int leftOverAmount)
    {
        if(leftOverAmount == 0) return 1;

        dpArray[0][0] = 1;

        for(int i=1; i<= coins.length; i++)
        {
            for(int j =0; j<= target; j++)
            {
                if(coins[i-1] > j)
                {
                    dpArray[i][j] = dpArray[i-1][j] ;
                }
                else
                {
                    dpArray[i][j] = dpArray[i-1][j] + dpArray[i][j - coins[i-1]];
                }
            }
        }
        return dpArray[coins.length][target];
    }

    public static void main(String[] args) {

    }
}