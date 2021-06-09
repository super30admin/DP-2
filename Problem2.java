
//518.
//TC : O(Amount*coins) O(A*c)
//SC : O(A*c)  recursive stack call &  cache array


class Solution {

    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length+1][amount+1];
        
        cache[0][0] = 1;

        for (int i = 1; i <= coins.length; i++)
        {
            //zero combinations using no coins
            cache[i][0] = 1;
            for (int j = 1; j <= amount; j++)
            {
                if(j >= coins[i-1])
                    cache[i][j] = cache[i-1][j] + cache[i][j-coins[i-1]];
                else
                    cache[i][j] = cache[i-1][j];

            }
        }
        return cache[coins.length][amount];
    }
}