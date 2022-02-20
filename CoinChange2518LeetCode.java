//time complexity : O(n*amount) n=number of coins present
//space complexity ; O(amount)
//I don't face any problems
//runs successfully on leetcode


public class CoinChange2518LeetCode {

    //bottom Up Approach

    public int change(int amount, int[] coins) {

        int[] prev = new int[amount+1];                     //creating prev array
        prev[0] = 1;                                        //assign first element of prev to 1

        int[] current = new int[amount+1];                  //creating current array
        current[0] = 1;                                     //assigning first element of current to 1

        for(int i=0; i<coins.length; i++){

            for(int j=1; j<=amount; j++){

                int select = (j-coins[i]) < 0 ? 0: current[j-coins[i]];     //selecting the coin
                int notSelect = prev[j];                                    //not selecting the coin

                current[j] = select + notSelect;                        //assign current to addition of select and notSelect ways

            }

            prev = current;

        }
        return prev[amount];                        //return the last element of prev

    }

}
