class Solution {
    // Recursive approach
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length==0)
        {
            return 0;
        }
            return recurse(coins, amount, 0);
        }

        private int recurse(int[]coins, int amount, int index)
        {
            if(amount<0 || coins.length==index)
            {
                return 0;
            }
            if(amount==0)
            {
                return 1;
            }

            int case1 = recurse(coins, amount, index+1);
            int case2 = recurse(coins, amount-coins[index], index);
            return case1+case2;
        }
        
    }

