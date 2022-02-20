//time complexity : O(n*amount) n=number of coins present
//space complexity ; O(amount)
//I don't face any problems
//runs successfully on leetcode


public class CoinChange2518LeetCode {

    //bottom Up Approach

    public int change(int amount, int[] coins) {

        int[] prev = new int[amount+1];
        prev[0] = 1;

        int[] current = new int[amount+1];
        current[0] = 1;

        for(int i=0; i<coins.length; i++){

            for(int j=1; j<=amount; j++){

                int select = (j-coins[i]) < 0 ? 0: current[j-coins[i]];
                int notSelect = prev[j];

                current[j] = select + notSelect;

            }

            prev = current;

        }
        return prev[amount];

    }

}
